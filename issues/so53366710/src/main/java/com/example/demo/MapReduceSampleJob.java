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
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.core.partition.support.SimpleStepExecutionSplitter;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.SystemCommandTasklet;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class MapReduceSampleJob {

	private static final int CHUNK_SIZE = 2;
	private static final int DEFAULT_PARTITION_SIZE = 4;
	private static final int TASKLET_TIMEOUT = 1000;

	private static final String PARTITIONED_STEP_NAME = "aggregateWordCountStep";
	private static final String WORKER_STEP_NAME = "wordCountStep";
	private static final String DEFAULT_PARTITION_PREFIX = "partition";

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	public MapReduceSampleJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public Step aggregateWordCountStep() {
		return stepBuilderFactory.get(PARTITIONED_STEP_NAME)
				.partitioner(WORKER_STEP_NAME, partitioner(null))
				.step(wordCountStep())
				.gridSize(DEFAULT_PARTITION_SIZE)
				.taskExecutor(new SimpleAsyncTaskExecutor())
				.splitter(stepExecutionSplitter(null))
				.aggregator(stepExecutionAggregator())
				.build();
	}

	// This is configured by default, but I want to make it explicit to show the splitter/aggregator APIs used together
	@Bean
	public SimpleStepExecutionSplitter stepExecutionSplitter(JobRepository jobRepository) {
		SimpleStepExecutionSplitter stepExecutionSplitter = new SimpleStepExecutionSplitter();
		stepExecutionSplitter.setPartitioner(partitioner(null));
		stepExecutionSplitter.setStepName(PARTITIONED_STEP_NAME);
		stepExecutionSplitter.setJobRepository(jobRepository);
		return stepExecutionSplitter;
	}

	@Bean
	public WordCountAggregator stepExecutionAggregator() {
		return new WordCountAggregator();
	}

	@Bean
	@StepScope
	public MultiResourcePartitioner partitioner(@Value("#{jobExecutionContext['inputFiles']}") Resource[] resources) {
		MultiResourcePartitioner multiResourcePartitioner = new MultiResourcePartitioner();
		multiResourcePartitioner.partition(DEFAULT_PARTITION_SIZE);
		multiResourcePartitioner.setKeyName("file");
		multiResourcePartitioner.setResources(resources);
		return multiResourcePartitioner;
	}

	@Bean
	@StepScope
	public FlatFileItemReader<String> itemReader(@Value("#{stepExecutionContext['file']}") Resource resource) {
		return new FlatFileItemReaderBuilder<String>()
				.resource(resource)
				.name("wordReader")
				.lineMapper(new PassThroughLineMapper())
				.build();
	}

	@Bean
	@StepScope
	public WordCountItemProcessor itemProcessor() {
		return new WordCountItemProcessor();
	}

	@Bean
	@StepScope
	public WordCountItemWriter itemWriter() {
		return new WordCountItemWriter();
	}

	@Bean
	public Step wordCountStep() {
		return stepBuilderFactory.get(WORKER_STEP_NAME)
				.<String, WordCount>chunk(CHUNK_SIZE)
				.reader(itemReader(null))
				.processor(itemProcessor())
				.writer(itemWriter())
				.build();
	}

	@Bean
	@StepScope
	public SystemCommandTasklet getSplitTasklet(
			@Value("#{jobParameters['inputFile']}") String inputFile,
			@Value("#{jobParameters['prefix']}") String prefix,
			@Value("#{jobParameters['partitionSize']}") Integer partitionSize,
			@Value("#{jobParameters['workingDirectory']}") String workingDirectory) {
		SystemCommandTasklet splitTasklet = new SystemCommandTasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				RepeatStatus repeatStatus = super.execute(contribution, chunkContext);
				JobExecution jobExecution = chunkContext.getStepContext().getStepExecution().getJobExecution();
				jobExecution.getExecutionContext().put("inputFiles", "file:" + workingDirectory + DEFAULT_PARTITION_PREFIX + "_*");
				return repeatStatus;
			}
		};
		splitTasklet.setCommand(String.format("split -a 1 -l %d %s %s", // tested on Mac OS which uses the BSD version of the 'split' command (which is different from the GNU version)
				partitionSize == null ? DEFAULT_PARTITION_SIZE : partitionSize,
				inputFile,
				prefix == null ? DEFAULT_PARTITION_PREFIX : prefix)
		);
		splitTasklet.setTimeout(TASKLET_TIMEOUT);
		splitTasklet.setWorkingDirectory(workingDirectory);
		return splitTasklet;
	}

	@Bean
	public Step splitFileStep() {
		return stepBuilderFactory.get("splitFileStep")
				.tasklet(getSplitTasklet(null, null, null, null))
				.build();
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job")
				.start(splitFileStep())
				.next(aggregateWordCountStep())
//				.next(cleanupStep()) // Could add a step to clean up the created partition files, but this has been omitted to inspect partition files after running the example
				.build();
	}

}
