package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableBatchProcessing
public class MyJobConfiguration {

	@Bean
	public ItemReader<Integer> itemReader() {
		return new ListItemReader<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) {
			@Override
			public synchronized Integer read() {
				return super.read();
			}
		};
	}

	@Bean
	public ItemWriter<Integer> itemWriter() {
		return new ItemWriter<Integer>() {
			@Override
			public synchronized void write(List<? extends Integer> items) {
				for (Integer item : items) {
					System.out.println("item = " + item);
				}
			}
		};
	}

	@Bean
	@StepScope
	public TaskExecutor taskExecutor(@Value("#{jobParameters['poolSize']}") int poolSize) {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(poolSize);
		executor.setMaxPoolSize(poolSize);
		return executor;
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Integer, Integer>chunk(5)
						.reader(itemReader())
						.writer(itemWriter())
						.taskExecutor(taskExecutor(0))
						.build())
				.build();
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
		ApplicationContext context = new AnnotationConfigApplicationContext(MyJobConfiguration.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		JobParameters jobParameters = new JobParametersBuilder()
				//.addLong("poolSize", 5L)
				.addString("poolSize", "null")
				.toJobParameters();
		jobLauncher.run(job, jobParameters);
	}

}
