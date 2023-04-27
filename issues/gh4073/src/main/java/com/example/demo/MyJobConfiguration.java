package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.JdbcTransactionManager;

@Configuration
public class MyJobConfiguration {

	@Bean
	public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
//		RunIdIncrementer jobParametersIncrementer = new RunIdIncrementer();
		DefaultJobParametersValidator jobParametersValidator = new DefaultJobParametersValidator();
		jobParametersValidator.setRequiredKeys(new String[]{"name"});

		return new JobBuilder("job", jobRepository)
				.start(new StepBuilder("step", jobRepository)
						.tasklet((contribution, chunkContext) -> {
							System.out.println("Hello world!");
							return RepeatStatus.FINISHED;
						}, transactionManager).build())
				.incrementer(new MyIncrementer())
				.validator(jobParametersValidator)
				.build();
	}

	static class MyIncrementer implements JobParametersIncrementer {

		@Override
		public JobParameters getNext(JobParameters parameters) {
			Map<String, JobParameter<?>> newParameters = new HashMap<>(parameters.getParameters());
			newParameters.put("name", new JobParameter<>("foo", String.class, true));
			return new JobParameters(newParameters);
		}
	}


}
