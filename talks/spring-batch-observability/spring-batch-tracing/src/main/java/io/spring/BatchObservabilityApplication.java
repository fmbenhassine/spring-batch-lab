package io.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BatchObservabilityApplication {

	public static void main(String[] args) throws Exception {
		Class<?>[] classes = {DataSourceConfiguration.class, ObservabilityConfiguration.class, JobConfiguration.class};
		ApplicationContext context = new AnnotationConfigApplicationContext(classes);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());
		Thread.sleep(1000); // give the zipkin reporter a chance to push tracing data
	}
}