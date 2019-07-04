package com.example.demo2;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyJob {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	public Step step1() {
		return steps.get("step1")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("hello");
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Step step2() {
		return steps.get("step2")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("world");
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step1())
				.next(step2())
				.build();
	}

}
