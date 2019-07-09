package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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
				.partitioner(slaveStep().getName(), partitioner())
				.step(slaveStep())
				.gridSize(10000)
				.taskExecutor(threadPoolTaskExecutor())
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(10);
		threadPoolTaskExecutor.setMaxPoolSize(1000);
		return threadPoolTaskExecutor;
	}

	@Bean
	public Partitioner partitioner() {
		return gridSize -> {
			Map<String, ExecutionContext> map = new HashMap<>(gridSize);
			for (int i = 0; i < gridSize; i++) {
				ExecutionContext executionContext = new ExecutionContext();
				executionContext.put("data", "data" + i);
				String key = "partition" + i;
				map.put(key, executionContext);
			}
			return map;
		};
	}

	@Bean
	public Step slaveStep() {
		return steps.get("slaveStep")
				.tasklet(getTasklet(null))
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	@StepScope
	public Tasklet getTasklet(@Value("#{stepExecutionContext['data']}") String partitionData) {
		return (contribution, chunkContext) -> {
//			System.out.println(Thread.currentThread().getName() + " processing partition data = " + partitionData);
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Job partitionJob(final ThreadPoolTaskExecutor threadPoolTaskExecutor) {
		return jobs.get("partitionJob")
				.start(masterStep())
				.listener(new JobExecutionListenerSupport() {
					@Override
					public void afterJob(JobExecution jobExecution) {
						threadPoolTaskExecutor.shutdown();
					}
				})
				.build();
	}

}
