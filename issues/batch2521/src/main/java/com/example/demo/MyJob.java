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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Bean
	public JdbcCursorItemReader<Person> itemReader(DataSource dataSource) {
		String sql = "select * from person where id = :id and name = :name";
		Map<String, Object> namedParameters = new HashMap<String, Object>() {{
			put("id", 1);
			put("name", "foo");
		}};

		String preparedSql = NamedParameterUtils.substituteNamedParameters(sql, new MapSqlParameterSource(namedParameters));
		PreparedStatementSetter preparedStatementSetter = new ArgumentPreparedStatementSetter(NamedParameterUtils.buildValueArray(sql, namedParameters));

		return new JdbcCursorItemReaderBuilder<Person>()
				.name("personItemReader")
				.dataSource(dataSource)
				.rowMapper(new PersonRowMapper())
				.sql(preparedSql)
				.preparedStatementSetter(preparedStatementSetter)
				.build();
	}

	// example with named parameters as list to answer: https://stackoverflow.com/questions/54782690
	// inspired by https://stackoverflow.com/a/57471284/5019386
//	@Bean
//	public JdbcCursorItemReader<Person> itemReader(DataSource dataSource) {
//		String sql = "select * from person where id in (:ids)";
//		Map<String, Object> namedParameters = new HashMap<String, Object>() {{
//			put("ids", Arrays.asList(2, 3));
//		}};
//
//		ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement(sql);
//		MapSqlParameterSource paramSource = new MapSqlParameterSource(namedParameters);
//		String sqlToUse = NamedParameterUtils.substituteNamedParameters(parsedSql, paramSource);
//		List<SqlParameter> declaredParams = NamedParameterUtils.buildSqlParameterList(parsedSql, paramSource);
//		Object[] parameters = NamedParameterUtils.buildValueArray(parsedSql, paramSource, declaredParams);
//		PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(sql, declaredParams);
//		PreparedStatementSetter preparedStatementSetter = factory.newPreparedStatementSetter(parameters);
//
//		return new JdbcCursorItemReaderBuilder<Person>()
//				.name("personItemReader")
//				.dataSource(dataSource)
//				.rowMapper(new PersonRowMapper())
//				.sql(sqlToUse)
//				.preparedStatementSetter(preparedStatementSetter)
//				.build();
//	}

	@Bean
	public ItemWriter<Person> itemWriter() {
		return items -> {
			for (Person item : items) {
				System.out.println("item = " + item);
			}
		};
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps, DataSource dataSource) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Person, Person>chunk(5)
						.reader(itemReader(dataSource))
						.writer(itemWriter())
						.build())
				.build();
	}

}
