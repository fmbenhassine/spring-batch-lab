package com.example.demo;

import java.sql.SQLException;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	public Step step1() {
		return steps.get("step1")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("hello");
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Step step2() {
		return steps.get("step2")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("world");
					String desc = "";
					for (int i = 1; i < 2500; i++) {
						desc += "a";
					}
					desc += "¥"; // the last character will take more than one byte
					chunkContext.getStepContext().getStepExecution().setExitStatus(new ExitStatus("FAILED", desc));
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step1())
				.next(step2())
				.build();
	}

	@Bean
	public DataSource dataSource() throws SQLException {
		OracleDataSource oracleDataSource = new OracleDataSource();
		oracleDataSource.setURL("jdbc:oracle:thin:@localhost:1521:XE");
		oracleDataSource.setUser("system");
		oracleDataSource.setPassword("root");
		return oracleDataSource;
	}

}
