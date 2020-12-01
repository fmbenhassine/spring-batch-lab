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

import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableBatchProcessing
public class MyJobConfiguration {

	private final JobBuilderFactory jobs;
	private final StepBuilderFactory steps;
	
	public MyJobConfiguration(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public ItemReader<Customer> itemReader() {
		return new ListItemReader<>(Arrays.asList(
				new Customer("foo1"),
				new Customer("bar1"),
				new Customer("foo2"),
				new Customer("bar2")
		));
	}

	@Bean
	public ItemProcessor<Customer, Customer> itemProcessor() {
		return item -> {
			if (item.getName().startsWith("bar")) {
				throw new Exception("No bars here!");
			}
			return item;
		};
	}
	
	@Bean
	public ItemProcessListener<Customer, Customer> itemProcessListener(ProcessingErrorRepository repository) {
		return new ItemProcessListener<Customer, Customer>() {

			@Override
			public void beforeProcess(Customer customer) {
				
			}

			@Override
			public void afterProcess(Customer customer, Customer customer2) {

			}

			@Override
			@Transactional(propagation = Propagation.REQUIRES_NEW)
			public void onProcessError(Customer customer, Exception e) {
				repository.save(new ProcessingError(customer.getName(), e.getMessage()));
			}
		};
	}

	@Bean
	public ItemWriter<Customer> itemWriter(CustomerRepository repository) {
		return list -> {
			for (Customer customer : list) {
				repository.save(customer);
			}
		};
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<Customer, Customer>chunk(2)
				.reader(itemReader())
				.processor(itemProcessor())
				.writer(itemWriter(null))
				.faultTolerant()
				.skip(Exception.class)
				.skipLimit(10)
				.listener(itemProcessListener(null))
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step())
				.build();
	}

}
