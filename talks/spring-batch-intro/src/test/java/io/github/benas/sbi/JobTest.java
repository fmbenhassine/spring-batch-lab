package io.github.benas.sbi;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JobConfiguration.class, JobTest.TestConfiguration.class})
public class JobTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Ignore
	@Test
	public void testJob() throws Exception {
		// given
		JobParameters uniqueJobParameters = jobLauncherTestUtils.getUniqueJobParameters();
		JobParameters jobParameters = new JobParametersBuilder(uniqueJobParameters)
				.addString("name", "foo")
				.toJobParameters();

		// when
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

		// then
		Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

	@Configuration
	public static class TestConfiguration {

		@Bean
		public JobLauncherTestUtils jobLauncherTestUtils() {
			return new JobLauncherTestUtils();
		}

	}
}
