package com.example.so75784914;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBatchTest
@SpringJUnitConfig({JobConfig.class})

class So75784914ApplicationTests {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void employeeJobExecutionTest() throws Exception {
		JobParameters jobParameter = new JobParametersBuilder()
				.addString("fileName", "output.csv")
				.toJobParameters();
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameter);
		Assertions.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

	}

}
