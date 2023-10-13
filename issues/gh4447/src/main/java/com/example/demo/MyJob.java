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

import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
public class MyJob {

	private static final int PAGE_SIZE = 4;
	private static final int CHUNK_SIZE = PAGE_SIZE; // for better performance, see
	// https://github.com/spring-projects/spring-batch/blob/main/spring-batch-infrastructure/src/main/java/org/springframework/batch/item/database/JpaPagingItemReader.java#L55-L56
	// even though this is for JpaPagingItemReader (the same applies for RepositoryItemReader as well since it is a paging reader)


	@Bean
	public RepositoryItemReader<Customer> itemReader(CustomerPagingRepository customerRepository) {
		return new RepositoryItemReaderBuilder<Customer>()
				.name("customerItemReader")
				.repository(customerRepository)
				.methodName("findAll")
				.pageSize(PAGE_SIZE)
				.sorts(Map.of("id", Sort.Direction.ASC))
				.build();
	}

	@Bean
	public ItemWriter<Customer> itemWriter() {
		return customers -> {
			for (Customer customer : customers) {
				System.out.println("customer = " + customer);
			}
		};
	}

	@Bean
	public Step step(JobRepository jobRepository, JpaTransactionManager transactionManager, CustomerPagingRepository customerRepository) {
		return new StepBuilder("step", jobRepository)
				.<Customer, Customer>chunk(CHUNK_SIZE, transactionManager)
				.reader(itemReader(customerRepository))
				.writer(itemWriter())
				.build();
	}

	@Bean
	public Job job(JobRepository jobRepository, Step step) {
		return new JobBuilder("job", jobRepository)
				.start(step)
				.build();
	}

}
