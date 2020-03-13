package com.example.demo;

import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;

public class WordCountItemWriter implements ItemWriter<WordCount> {

	private StepExecution stepExecution;

	@Override
	public void write(List<? extends WordCount> items) {
		for (WordCount wordCount : items) {
			stepExecution.getExecutionContext().put(wordCount.getWord(), wordCount.getCount());
		}
	}

	@BeforeStep
	public void saveStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}
}
