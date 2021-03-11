package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class BootifulBatchApplication {

	public static void main(String[] args) {
		System.exit(
				SpringApplication.exit(
						SpringApplication.run(BootifulBatchApplication.class, args)
				)
		);
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.incrementer(new RunIdIncrementer())
				.start(steps.get("step")
						.tasklet((contribution, chunkContext) -> {
							System.out.println("Hello world!");
							return RepeatStatus.FINISHED;
						})
						.build())
				.build();
	}

}
