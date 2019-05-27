package com.example.demo;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.JdbcJobInstanceDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.H2SequenceMaxValueIncrementer;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class DemoStopBatchJob {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(DemoStopBatchJob.class, args);
		JobOperator jobOperator = context.getBean(JobOperator.class);

		// Try to stop a running execution
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start("stopping job execution");
//		boolean stop = jobOperator.stop(10000L);
//		stopWatch.stop();
//		System.out.println("stop signal sent = " + stop);
//		System.out.println(stopWatch.prettyPrint());
		// Even if this fails with (Job execution should be running to be stopped,
		// the call to GET_JOB_FROM_EXECUTION_ID is still executed

		// Try to isolate the call that uses GET_JOB_FROM_EXECUTION_ID

		// first, we need a job execution
		JobExplorer jobExplorer = context.getBean(JobExplorer.class);
		JobExecution jobExecution = jobExplorer.getJobExecution(10000L);

		// second, call jdbcJobInstanceDao.getJobInstance with that job execution
		JdbcJobInstanceDao jdbcJobInstanceDao = new JdbcJobInstanceDao();
		jdbcJobInstanceDao.setJobIncrementer(new H2SequenceMaxValueIncrementer());
		jdbcJobInstanceDao.setJdbcTemplate(context.getBean(JdbcTemplate.class));
		jdbcJobInstanceDao.afterPropertiesSet();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("get job instance");
		JobInstance jobInstance = jdbcJobInstanceDao.getJobInstance(jobExecution);
		stopWatch.stop();
		System.out.println("jobInstance = " + jobInstance);
		System.out.println(stopWatch.prettyPrint());
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
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


}
