/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.database.support.ListPreparedStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * This is for https://stackoverflow.com/questions/54782690
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = NamedParametersJdbcCursorItemReaderAsListTest.TestConfiguration.class)
public class NamedParametersJdbcCursorItemReaderAsListTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private JdbcCursorItemReader<Person> itemReader;

	@Before
	public void setUp() {
		jdbcTemplate.execute("create table person (id int primary key, name varchar(20));");
		jdbcTemplate.execute("insert into person values (1, 'foo');");
		jdbcTemplate.execute("insert into person values (2, 'bar');");
		jdbcTemplate.execute("insert into person values (3, 'baz');");
		itemReader.open(new ExecutionContext());
	}

	@Test
	public void testReadDataWithNamedParameters() throws Exception {
		Person person = itemReader.read();
		Assert.assertNotNull(person);
		Assert.assertEquals(1, person.getId());
		Assert.assertEquals("foo", person.getName());

		person = itemReader.read();
		Assert.assertNotNull(person);
		Assert.assertEquals(2, person.getId());
		Assert.assertEquals("bar", person.getName());

		person = itemReader.read();
		Assert.assertNull(person);
	}

	@Configuration
	static class TestConfiguration {

		@Bean
		public JdbcCursorItemReader<Person> itemReader() {
			String sql = "select * from person where id in (:ids)";
			Map<String, Object> namedParameters = new HashMap<String, Object>() {{
				put("ids", Arrays.asList(1, 2));
			}};
			return new JdbcCursorItemReaderBuilder<Person>()
					.name("personItemReader")
					.dataSource(dataSource())
					.rowMapper(new PersonRowMapper())
					.sql(NamedParameterUtils.substituteNamedParameters(sql, new MapSqlParameterSource(namedParameters)))
					.preparedStatementSetter(new ListPreparedStatementSetter(flatten(Arrays.asList(NamedParameterUtils.buildValueArray(sql, namedParameters)))))
					.build();
		}

		// quick and dirty, should be tested and can certainly be simplified with Java 8 streams APIs
		private List<Object> flatten(List<Object> parameters) {
			List<Object> flatParameters = new ArrayList<>();
			for (Object parameter : parameters) {
				if (parameter.getClass().isArray()) {
					flatParameters.addAll(Arrays.asList((Object[]) parameter));
				} else if (parameter instanceof Collection) {
					flatParameters.addAll((Collection) parameter);
				} else {
					flatParameters.add(parameter);
				}
			}
			return flatParameters;
		}

		@Bean
		public DataSource dataSource() {
			return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.H2)
					.addScript("/org/springframework/batch/core/schema-drop-h2.sql")
					.addScript("/org/springframework/batch/core/schema-h2.sql")
					.build();
		}

		@Bean
		public JdbcTemplate jdbcTemplate() {
			return new JdbcTemplate(dataSource());
		}

	}

}
