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

package com.example.demo1;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.lang.Nullable;

/**
 * Sample of two steps running in parallel, but processing items concurrently
 * from the same blocking queue (This is basically the producer/consumer pattern)
 */
@SpringBootApplication
@EnableBatchProcessing
public class ConcurrentStepsSample {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public ConcurrentStepsSample(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public BlockingQueue<Person> queue() {
		return new ArrayBlockingQueue<>(100);
	}

	@Bean
	public Step step1() {
		return steps.get("step1")
				.<Person, Person>chunk(10)
				.reader(new IteratorItemReader<>(IntStream.rangeClosed(1, 100).mapToObj(i -> new Person("foo" + i)).iterator()))
				.writer(new BlockingQueueItemWriter<>(queue()))
				.build();
	}

	@Bean
	public Step step2() {
		return steps.get("step2")
				.<Person, Person>chunk(10)
				.reader(new BlockingQueueItemReader<>(queue()))
				.writer(items -> {
					for (Person item : items) {
						System.out.println("item = " + item);
					}
				})
				.build();
	}

	@Bean
	public Job Job() {
		return jobs.get("job")
				.flow(step1())
				.split(new SimpleAsyncTaskExecutor())
				.add(new FlowBuilder<Flow>("parallelFlow")
						.start(step2())
						.build())
				.end()
				.build();
	}

	class BlockingQueueItemReader<T> implements ItemReader<T> {

		private BlockingQueue<T> queue;

		BlockingQueueItemReader(BlockingQueue<T> queue) {
			this.queue = queue;
		}

		@Nullable
		@Override
		public T read() throws Exception {
			return queue.poll(1, TimeUnit.SECONDS);
		}
	}

	class BlockingQueueItemWriter<T> implements ItemWriter<T> {

		private BlockingQueue<T> queue;

		BlockingQueueItemWriter(BlockingQueue<T> queue) {
			this.queue = queue;
		}

		@Override
		public void write(List<? extends T> items) throws Exception {
			for (T item : items) {
				queue.put(item);
			}
		}
	}

	class Person {

		private String name;

		public Person() {
		}

		Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					'}';
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentStepsSample.class, args);
	}
}
