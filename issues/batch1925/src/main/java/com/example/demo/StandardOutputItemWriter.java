package com.example.demo;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class StandardOutputItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) {
		for (String item : items) {
			System.out.println("item = " + item);
		}
	}
}
