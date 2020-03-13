package com.example.demo;

import java.time.LocalDateTime;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

@Configuration
public class MyJob {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.tasklet((contribution, chunkContext) -> {
					System.out.println(LocalDateTime.now() + " hello world");
					Thread.sleep(20000);
					return RepeatStatus.FINISHED;
				})
				.transactionAttribute(new DefaultTransactionAttribute() {{
					setTimeout(10);
				}})
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step())
				.build();
	}

	@Bean
	public BatchConfigurer batchConfigurer(DataSource dataSource) {
		return new DefaultBatchConfigurer() {
			@Override
			public PlatformTransactionManager getTransactionManager() {
				DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
				transactionManager.setDefaultTimeout(5);
				return transactionManager;
			}
		};

	}

}
