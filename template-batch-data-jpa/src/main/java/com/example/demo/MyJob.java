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

import java.util.HashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

@Configuration
@EnableBatchProcessing
public class MyJob {

	private static final int PAGE_SIZE = 4;

	private static final int CHUNK_SIZE = 2;

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public ItemReader<Customer> itemReader(CustomerRepository customerRepository) {
		return new RepositoryItemReaderBuilder<Customer>()
				.name("customerItemReader")
				.repository(customerRepository)
				.methodName("findAll")
				.pageSize(PAGE_SIZE)
				.sorts(new HashMap<String, Sort.Direction>() {{
					put("id", Sort.Direction.ASC);
				}})
				.build();
	}

	@Bean
	public ItemWriter<Customer> itemWriter() {
		return list -> {
			for (Customer customer : list) {
				System.out.println("customer = " + customer);
			}
		};
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<Customer, Customer>chunk(CHUNK_SIZE)
				.reader(itemReader(null))
				.writer(itemWriter())
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step())
				.build();
	}

}
