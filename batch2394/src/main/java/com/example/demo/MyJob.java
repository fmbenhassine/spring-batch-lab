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

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.batch.support.DatabaseType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJob {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public JdbcPagingItemReader<Person> itemReader(DataSource dataSource) throws Exception {
		JdbcPagingItemReader<Person> reader = new JdbcPagingItemReader<>();
		reader.setDataSource(dataSource);
		SqlPagingQueryProviderFactoryBean factoryBean = new SqlPagingQueryProviderFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setDatabaseType(String.valueOf(DatabaseType.MYSQL)); // to verify
		factoryBean.setSelectClause("select p.*, a.name");
		factoryBean.setFromClause("from PERSON as p JOIN ADDRESS as a on p.address_id = a.address_id");
		factoryBean.setSortKey("p.name");
		reader.setQueryProvider(factoryBean.getObject());
		reader.setRowMapper((resultSet, i) -> {
			Person person = new Person();
			person.setId(resultSet.getInt(1));
			person.setName(resultSet.getString(2));
			Address address = new Address();
			address.setId(resultSet.getInt(3));
			address.setName(resultSet.getString(4));
			person.setAddress(address);
			return person;
		});
		reader.setFetchSize(2);
		reader.setPageSize(2);
		reader.afterPropertiesSet();
		return reader;
	}

	@Bean
	public ItemWriter<Person> itemWriter() {
		return items -> {
			for (Person item : items) {
				System.out.println("item = " + item);
			}
		};
	}

	@Bean
	public Step step() throws Exception {
		return steps.get("step")
				.<Person, Person>chunk(2)
				.reader(itemReader(null))
				.writer(itemWriter())
				.build();
	}

	@Bean
	public Job job() throws Exception {
		return jobs.get("job")
				.incrementer(new RunIdIncrementer())
				.start(step())
				.build();
	}

}
