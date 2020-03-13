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

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class PartitionJobSample {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public PartitionJobSample(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public Step masterStep() {
		return steps.get("masterStep")
				.partitioner(slaveStep().getName(), new RangePartitioner())
				.step(slaveStep())
				.gridSize(3)
				.taskExecutor(new SimpleAsyncTaskExecutor())
				.build();
	}

	@Bean
	public Step slaveStep() {
		return steps.get("slaveStep")
				.<String, String>chunk(1)
				.reader(itemReader(null, null))
				.writer(itemWriter())
				.build();
	}

	@Bean
	@StepScope
	public FlatFileItemReader<String> itemReader(@Value("#{stepExecutionContext['fromId']}") Integer fromId, @Value("#{stepExecutionContext['toId']}") Integer toId) {
		return new FlatFileItemReaderBuilder<String>()
				.resource(new FileSystemResource("src/main/resources/data.txt"))
				.saveState(false)
				.lineMapper(new PassThroughLineMapper())
				.linesToSkip(fromId)
				.maxItemCount(toId)
				.build();
	}

	@Bean
	public ItemWriter<String> itemWriter() {
		return items -> {
			for (String item : items) {
				System.out.println(Thread.currentThread().getName() + " writing item = " + item);
			}
		};
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(masterStep())
				.build();
	}

}
