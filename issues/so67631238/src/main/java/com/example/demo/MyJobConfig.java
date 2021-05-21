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

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJobConfig {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	public MyJobConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public ListItemReader<Customer> itemReader() {
		return new ListItemReader<>(Arrays.asList(
				new Customer("foo1", "bar1"),
				new Customer("foo2", "bar2"),
				new Customer("foo3", "bar3"),
				new Customer("foo4", "bar4")
		));
	}

	@Bean
	public RepositoryItemWriter<Customer> itemWriter(CustomerRepository customerRepository) {
		return new RepositoryItemWriterBuilder<Customer>()
				.repository(customerRepository)
				.build();
	}

	@Bean
	public Step step(CustomerRepository customerRepository) {
		return stepBuilderFactory.get("step")
				.<Customer, Customer>chunk(2)
				.reader(itemReader())
				.writer(itemWriter(customerRepository))
				.build();
	}

	@Bean
	public Job job(CustomerRepository customerRepository) {
		return jobBuilderFactory.get("job")
				.start(step(customerRepository))
				.build();
	}

}
