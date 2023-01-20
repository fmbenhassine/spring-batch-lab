package io.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.support.JdbcTransactionManager;

@SpringBootApplication
public class SpringBatchAzureApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchAzureApp.class, args);
	}

	@Bean
	public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
		Step step = new StepBuilder("step", jobRepository).tasklet((contribution, chunkContext) -> {
			System.out.println("Hello Azure World!");
			return RepeatStatus.FINISHED;
		}, transactionManager).build();

		return new JobBuilder("job", jobRepository)
				.start(step).build();

	}

}
