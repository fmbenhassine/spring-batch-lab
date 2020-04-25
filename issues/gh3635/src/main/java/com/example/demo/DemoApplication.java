package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.JdbcStepExecutionDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StopWatch;

// docker run -e POSTGRES_PASSWORD=root -d -p 5432:5432 postgres

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		JobRepository jobRepository = context.getBean(JobRepository.class);
		JobExplorer jobExplorer = context.getBean(JobExplorer.class);
		JobInstance jobInstance = jobExplorer.getLastJobInstance("job");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		jobRepository.getLastStepExecution(jobInstance, "step"); // calls jdbcStepExecutionDao.getLastStepExecution(jobInstance, "step");
		stopWatch.stop();
		System.out.println(stopWatch.getLastTaskTimeMillis());
		// SB 4.2.2: 1359ms
		// SB 4.3.0.BUILD-SNAPSHOT: 52ms
		
		// generate a million job/step executions
//		Job job = context.getBean(Job.class);
//		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
//		for (int i = 0; i < 1_000_000; i++) {
//			JobParameters jobParameters = new JobParametersBuilder()
//					.addLong("id", System.currentTimeMillis())
//					.toJobParameters();
//			jobLauncher.run(job, jobParameters);
//		}
	}

}
