package com.example.gh3880;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

class LogStepExecutionListener implements StepExecutionListener {

		@Override
		public void beforeStep(StepExecution stepExecution) {
			System.out.println("LogStepExecutionListener.beforeStep");
		}

		@Override
		public ExitStatus afterStep(StepExecution stepExecution) {
			return stepExecution.getExitStatus();
		}
	}