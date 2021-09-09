package io.spring;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@SpringBootApplication
@EnableBatchProcessing
public class DemoApplication extends BasicBatchConfigurer {

	protected DemoApplication(BatchProperties properties, DataSource dataSource, TransactionManagerCustomizers transactionManagerCustomizers) {
		super(properties, dataSource, transactionManagerCustomizers);
	}

	@Override
	protected JobLauncher createJobLauncher() throws Exception {
		SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
		simpleJobLauncher.setJobRepository(getJobRepository());
		SimpleAsyncTaskExecutor taskExecutor = taskExecutor();
		simpleJobLauncher.setTaskExecutor(taskExecutor);
		simpleJobLauncher.afterPropertiesSet();
		return simpleJobLauncher;
	}

	@Bean
	// if this is auto-configured by default in batch's JobLauncher,
	// the app exits prematurely before waiting for the job to finish.
	// This could be accidentally declared by the user without this side-effect in mind
	public SimpleAsyncTaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setDaemon(true);
		return taskExecutor;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.tasklet((contribution, chunkContext) -> {
							Thread.sleep(10000);
							System.out.println(Thread.currentThread().getName() + ": hello world");
							return RepeatStatus.FINISHED;
						})
						.build())
				.build();
	}

}
