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

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.ChunkListenerSupport;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public ChattyJpaPagingItemReader<Customer> itemReader(EntityManagerFactory entityManagerFactory) {
		ChattyJpaPagingItemReader<Customer> chattyJpaPagingItemReader = new ChattyJpaPagingItemReader<>();
		chattyJpaPagingItemReader.setName("customerItemReader");
		chattyJpaPagingItemReader.setEntityManagerFactory(entityManagerFactory);
		chattyJpaPagingItemReader.setPageSize(PAGE_SIZE);
		chattyJpaPagingItemReader.setQueryString("from Customer");

		return chattyJpaPagingItemReader;
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
	public ChunkListener chunkListener() {
		return new ChunkListenerSupport() {
			@Override
			public void beforeChunk(ChunkContext context) {
				System.out.println("MyJob.beforeChunk");
			}

			@Override
			public void afterChunk(ChunkContext context) {
				System.out.println("MyJob.afterChunk");
			}
		};
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<Customer, Customer>chunk(CHUNK_SIZE)
				.reader(itemReader(null))
				.writer(itemWriter())
				.listener(chunkListener())
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step())
				.build();
	}

}
