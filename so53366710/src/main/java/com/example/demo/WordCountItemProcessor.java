package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;

public class WordCountItemProcessor implements ItemProcessor<String, String> {

	private StepExecution stepExecution;

	private Map<String, Integer> counts = new HashMap<>();

	@Override
	public String process(String item) {
		counts.put(item, counts.get(item) == null ? 1 : counts.get(item) + 1);
		stepExecution.getExecutionContext().put("wordCount", counts);
		return item;
	}

	@BeforeStep
	public void saveStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}
}
