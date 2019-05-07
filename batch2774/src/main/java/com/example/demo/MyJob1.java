package com.example.demo;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyJob1 {

	private Random random;

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob1(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
		this.random =new Random();
	}

	@Bean
	public Step step1() {
		return steps.get("step1")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("hello");
					Thread.sleep(random.nextInt(3000));
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Step step2() {
		return steps.get("step2")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("world");
					int nextInt = random.nextInt(3000);
					Thread.sleep(nextInt);
					if (nextInt % 5 == 0) {
						throw new Exception("Boom!");
					}
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Job job1() {
		return jobs.get("job1")
				.start(step1())
				.next(step2())
				.build();
	}

}
