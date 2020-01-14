package com.example.demo;

import java.util.Date;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class DemoApplication {

	/**
	 * // TODO use testcontainers to setup things, but for now:
	 * 1. mysql should be up and running: docker run -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql
	 * 2. create schema test
	 * 3. run MySQL DDL script: https://github.com/spring-projects/spring-batch/blob/master/spring-batch-core/src/main/resources/org/springframework/batch/core/schema-mysql.sql
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		Date date = new Date();
		JobParameters jobParameters = new JobParametersBuilder()
				.addDate("date", date)
//				.addLong("date", date.getTime()) // the issue does not happen when using LONG type
				.toJobParameters();
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);

		JobOperator jobOperator = context.getBean(JobOperator.class);
		jobOperator.restart(jobExecution.getId());

		// expected result: should have a single job instance with two job executions
		// TODO add proper test with assertions
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step1")
						.tasklet((contribution, chunkContext) -> {
							throw new Exception("expected failure");
						})
						.build())
				.build();
	}

	@Bean
	public DataSource dataSource() {
	    HikariDataSource datasource = new HikariDataSource();
	    datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    datasource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
	    datasource.setUsername("root");
	    datasource.setPassword("root");
	    return datasource;
	}

	@Bean
	public JobOperator jobOperator(
			JobLauncher jobLauncher,
			JobRegistry jobRegistry,
			JobExplorer jobExplorer,
			JobRepository jobRepository
	) {
		SimpleJobOperator jobOperator = new SimpleJobOperator();
		jobOperator.setJobExplorer(jobExplorer);
		jobOperator.setJobLauncher(jobLauncher);
		jobOperator.setJobRegistry(jobRegistry);
		jobOperator.setJobRepository(jobRepository);
		return jobOperator;
	}

	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
		JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
		jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
		return jobRegistryBeanPostProcessor;
	}

}
