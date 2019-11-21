package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.PlatformTransactionManager;

// BATCH-2351: When using java config and importing XML, step/job scoped beans don't get proxied:

// the following example uses Java config and imports XML, and yet step/job scoped beans get proxied as expected

@Configuration
@ImportResource(value={"classpath:job-context.xml"}) // the job is configured in XML
public class DemoApplication {

	// infrastructure beans are configured in Java

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}

	@Bean
	public JobRepository jobRepository() throws Exception {
		MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean = new MapJobRepositoryFactoryBean();
		mapJobRepositoryFactoryBean.setTransactionManager(transactionManager());
		return mapJobRepositoryFactoryBean.getObject();
	}

	@Bean
	public JobLauncher jobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository());
		return jobLauncher;
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("param", "foo")
				.toJobParameters();
		jobLauncher.run(job, jobParameters);
	}
}
