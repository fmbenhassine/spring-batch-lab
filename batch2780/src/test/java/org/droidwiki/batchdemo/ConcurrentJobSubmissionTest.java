package org.droidwiki.batchdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.Test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.AbstractStep;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

public class ConcurrentJobSubmissionTest {

	@Test
	public void name() throws InterruptedException {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JobConfiguration.class);
		JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
		Job job = applicationContext.getBean(Job.class);

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 1; i <= 50; i++) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					JobParameters jobParameters = new JobParametersBuilder()
							.addLong("id", Thread.currentThread().getId())
							.toJobParameters();
					try {
						jobLauncher.run(job, jobParameters);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		System.out.println("done");
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}

	@Configuration
	@EnableBatchProcessing
	public static class JobConfiguration {

		@Bean
		public JobRepository jobRepository(PlatformTransactionManager transactionManager) throws Exception {
			JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
			factory.setDataSource(dataSource());
			factory.setTransactionManager(transactionManager);
			factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
			factory.afterPropertiesSet();

			return factory.getObject();
		}

		@Bean
		public JobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
			ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
			taskExecutor.setMaxPoolSize(10);
			taskExecutor.afterPropertiesSet();
			SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
			jobLauncher.setJobRepository(jobRepository);
			jobLauncher.setTaskExecutor(taskExecutor);
			jobLauncher.afterPropertiesSet();
			return jobLauncher;
		}

		@Bean
		public DataSource dataSource() {
		    MysqlDataSource datasource = new MysqlDataSource();
		    datasource.setURL("jdbc:mysql://localhost:3306/springbatch");
		    datasource.setUser("root");
		    datasource.setPassword("root");
		    return datasource;
		}

		@Bean
		public Job demoJob(JobRepository jobRepository, Step demoStep) {
			SimpleJob job = new SimpleJob("demoJob");
			job.setJobRepository(jobRepository);
			job.addStep(demoStep);
			return job;
		}

		@Bean
		public Step demoStep(JobRepository jobRepository) {
			AbstractStep step = new AbstractStep() {
				@Override
				protected void doExecute(StepExecution stepExecution) throws Exception {
					System.out.println("Executing demoStep");
					Thread.sleep(5000);
				}
			};
			step.setJobRepository(jobRepository);

			return step;
		}

	}
}
