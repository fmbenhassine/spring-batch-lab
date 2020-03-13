package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

public class WordCountItemProcessor implements ItemProcessor<String, WordCount> {

	private Map<String, Integer> counts = new HashMap<>();

	@Override
	public WordCount process(String word) {
		int wordCount = counts.get(word) == null ? 1 : counts.get(word) + 1;
		counts.put(word, wordCount);
		return new WordCount(word, wordCount);
	}

}
