package com.example.demo;

class WordCount {

	private String word;

	private int count;

	WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

	String getWord() {
		return word;
	}

	int getCount() {
		return count;
	}
}
