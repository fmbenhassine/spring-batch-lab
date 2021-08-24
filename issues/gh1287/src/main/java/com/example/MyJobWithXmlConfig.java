package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


// step 2 is executed on restart with spring-batch-2.2.xsd, but not with spring-batch-3.0.xsd

public class MyJobWithXmlConfig {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("my-job.xml");
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		// use the same identifying parameters to ensure that the same job instance is executed
		JobParameters jobParameters = new JobParametersBuilder().addString("name", "foo").toJobParameters();
		System.out.println("first run:");
		jobLauncher.run(job, jobParameters);
		System.out.println("second run:");
		jobLauncher.run(job, jobParameters);
	}

}
