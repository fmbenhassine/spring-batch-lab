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
public class MyJob2 {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	public Step step12() {
		return steps.get("step12")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("hello2");
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Step step22() {
		return steps.get("step22")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("world2");
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Job job2() {
		return jobs.get("job2")
				.start(step12())
				.next(step22())
				.build();
	}

}
