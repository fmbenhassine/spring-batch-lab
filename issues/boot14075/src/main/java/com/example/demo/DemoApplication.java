package com.example.demo;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobExecutionEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.exit(
				SpringApplication.exit(
						SpringApplication.run(DemoApplication.class, args)
				)
		);
	}

	@Bean
	public ExitCodeGenerator exitCodeGenerator () {
		return new MyExitCodeGenerator();
	}

	class MyExitCodeGenerator implements ExitCodeGenerator, ApplicationListener<JobExecutionEvent> {

		private JobExecution jobExecution;

		@Override
		public int getExitCode() {
			ExitStatus exitStatus = jobExecution.getExitStatus();
			if (ExitStatus.FAILED.getExitCode().equals(exitStatus.getExitCode())) {
				return 42;
			}
			return 0;
		}

		@Override
		public void onApplicationEvent(JobExecutionEvent jobExecutionEvent) {
			this.jobExecution = jobExecutionEvent.getJobExecution();
		}
	}
}
