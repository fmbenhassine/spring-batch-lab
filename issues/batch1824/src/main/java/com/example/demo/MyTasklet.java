package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class MyTasklet implements Tasklet {

	private List<String> sqlsList = new ArrayList<>();

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("doing something with: " + sqlsList);
		return RepeatStatus.FINISHED;
	}

	public void setSqlsList(List<String> sqlsList) {
		this.sqlsList = sqlsList;
	}
}
