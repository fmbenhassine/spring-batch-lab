package com.example.demodb;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.support.JdbcTransactionManager;

@SpringBootApplication
public class DemoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDbApplication.class, args);
	}

	@Bean
	public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
		return new JobBuilder("job", jobRepository)
				.start(new StepBuilder("step", jobRepository)
						.tasklet((contribution, chunkContext) -> {
							System.out.println("hello world");
							return RepeatStatus.FINISHED;
						}, transactionManager)
						.build())
				.build();
	}

}
