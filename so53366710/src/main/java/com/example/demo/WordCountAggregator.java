package com.example.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.partition.support.StepExecutionAggregator;
import org.springframework.batch.item.ExecutionContext;

public class WordCountAggregator implements StepExecutionAggregator {

	private List<String> excludedKeys = Arrays.asList("file", "batch.taskletType", "wordReader.read.count", "batch.stepType");

	@Override
	public void aggregate(StepExecution result, Collection<StepExecution> executions) {
		Map<String, Integer> aggregateWordCounts = new HashMap<>();
		for (StepExecution execution : executions) {
			reduce(execution, aggregateWordCounts);
		}

		// print sorted word count in descending order
		aggregateWordCounts.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // sort by value in reverse order
				.forEach(System.out::println);
	}

	private void reduce(StepExecution execution, Map<String, Integer> aggregateWordCounts) {
		ExecutionContext executionContext = execution.getExecutionContext();
		for (Map.Entry<String, Object> wordCountEntry : executionContext.entrySet()) {
			String word = wordCountEntry.getKey();
			if (!excludedKeys.contains(word)) {
				Integer count = (Integer) wordCountEntry.getValue();
				Integer aggregateWordCount = aggregateWordCounts.get(word);
				aggregateWordCounts.put(word, aggregateWordCount == null ? count : aggregateWordCount + count);
			}
		}
	}
}
