package com.example.demo;

import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.AssertFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyJobTest {

	@Test
	public void testMyJob() throws Exception {
		// given
		ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);

		// when
		JobExecution jobExecution = jobLauncher.run(job, new JobParameters());

		// then
		Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
		AssertFile.assertLineCount(2, Paths.get("persons.txt").toFile());
	}
}
