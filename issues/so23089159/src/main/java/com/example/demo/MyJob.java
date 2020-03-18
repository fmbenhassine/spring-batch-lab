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

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Bean
	public JpaPagingItemReader<Customer> itemReader(EntityManagerFactory entityManagerFactory) {
		JpaPagingItemReader<Customer> jpaPagingItemReader = new JpaPagingItemReader<>();
		jpaPagingItemReader.setName("customerItemReader");
		jpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
		jpaPagingItemReader.setQueryString("from Customer");

		return jpaPagingItemReader;
	}

	@Bean
	public ItemWriter<Customer> itemWriter() {
		return list -> {
			for (Customer customer : list) {
				System.out.println("Writing customer = " + customer);
			}
		};
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Customer, Customer>chunk(2)
						.reader(itemReader(null))
						.writer(itemWriter())
						.build())
				.build();
	}

}
