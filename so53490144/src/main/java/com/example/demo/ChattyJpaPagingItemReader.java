package com.example.demo;

import org.springframework.batch.item.database.JpaPagingItemReader;

public class ChattyJpaPagingItemReader<T> extends JpaPagingItemReader<T> {

	@Override
	protected T doRead() throws Exception {
		T item = super.doRead();
		System.out.println("Reading customer = " + item);
		return item;
	}

}
