package com.example.demo;

import java.util.Map;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJobConfig {

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.incrementer(new MyCustomIncrementer())
				.start(steps.get("step")
						.tasklet((contribution, chunkContext) -> {
							System.out.println("hello world");
							return RepeatStatus.FINISHED;
						})
						.build())
				.build();
	}
	
	@Bean
	public DataSource dataSource() {
		MysqlDataSource datasource = new MysqlDataSource();
	    datasource.setURL("jdbc:mysql://localhost:3306/test");
	    datasource.setUser("root");
	    datasource.setPassword("root");
	    return datasource;
	}
	
	static class MyCustomIncrementer extends RunIdIncrementer {

		@Override
		public JobParameters getNext(JobParameters jobParameters) {
			JobParameters identifyingParameters = getIdentifyingParameters(jobParameters);
			return super.getNext(identifyingParameters);
		}

		private JobParameters getIdentifyingParameters(JobParameters jobParameters) {
			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
			for (Map.Entry<String, JobParameter> entry : jobParameters.getParameters().entrySet()) {
				if (entry.getValue().isIdentifying()) {
					jobParametersBuilder.addParameter(entry.getKey(), entry.getValue());
				}
			}
			return jobParametersBuilder.toJobParameters();
		}
	}

}
