package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Job1Configuration extends BaseJobConfiguration {
	
	@Bean
	public Job job1(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job1")
				.start(steps.get("step")
						.tasklet((contribution, chunkContext) -> {
							System.out.println("hello from job1");
							return RepeatStatus.FINISHED;
						})
						.build())
				.build();
	}

}