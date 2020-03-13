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
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StopWatch;

@Configuration
public class MyJob {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public ItemReader<String> itemReader() {
		List<String> names = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			names.add("foo" + i);
		}
		return new ListItemReader<String>(names) { // SynchronizedItemStreamReader requires an ItemStreamReader
			@Override
			public synchronized String read() {
				return super.read();
			}
		};
	}

	@Bean
	public ItemWriter<Customer> itemWriter(CustomerRepository customerRepository) {

		class SlowWriterDecorator<T> implements ItemWriter<T> {

			private RepositoryItemWriter<T> delegate;

			private SlowWriterDecorator(RepositoryItemWriter<T> delegate) {
				this.delegate = delegate;
			}

			@Override
			public void write(List<? extends T> list) throws Exception {
				System.out.println(Thread.currentThread().getName() + ": writing " + list);
				Thread.sleep(1000);
				delegate.write(list);
			}
		}

		RepositoryItemWriter<Customer> repositoryItemWriter = new RepositoryItemWriterBuilder<Customer>()
				.repository(customerRepository)
				.methodName("save")
				.build();
		return new SlowWriterDecorator<>(repositoryItemWriter);
	}

	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(10);
		taskExecutor.setMaxPoolSize(10);
		return taskExecutor;
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<String, Customer>chunk(10)
				.reader(itemReader())
				.processor((ItemProcessor<String, Customer>) s -> new Customer(s, s))
				.writer(itemWriter(null))
				.taskExecutor(taskExecutor())
				.build();
	}

	@Bean
	public Job job(final ThreadPoolTaskExecutor taskExecutor) {

		class ExecutionTimeJobExecutionListener implements JobExecutionListener {

			private StopWatch stopWatch = new StopWatch();

			@Override
			public void beforeJob(JobExecution jobExecution) {
				stopWatch.start();
			}

			@Override
			public void afterJob(JobExecution jobExecution) {
				stopWatch.stop();
				System.out.println("job took = " + stopWatch.getTotalTimeSeconds() + "s");
				taskExecutor.shutdown(); // without this, the app never stops
			}
		}

		return jobs.get("job")
				.start(step())
				.listener(new ExecutionTimeJobExecutionListener())
				.build();
	}

}
