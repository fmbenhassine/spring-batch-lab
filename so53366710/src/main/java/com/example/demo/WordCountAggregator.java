package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.partition.support.StepExecutionAggregator;

public class WordCountAggregator implements StepExecutionAggregator {

	@Override
	public void aggregate(StepExecution result, Collection<StepExecution> executions) {
		Map<String, Integer> aggregatedWordCount = new HashMap<>();
		for (StepExecution execution : executions) {
			Map<String, Integer> wordCount = (Map<String, Integer>) execution.getExecutionContext().get("wordCount");
			for (String word : wordCount.keySet()) {
				aggregatedWordCount.put(word, aggregatedWordCount.get(word) == null ? wordCount.get(word) : aggregatedWordCount.get(word) + wordCount.get(word));
			}
		}
		System.out.println("aggregatedWordCount = " + aggregatedWordCount);
	}
}
