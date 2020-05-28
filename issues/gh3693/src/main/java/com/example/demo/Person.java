package com.example.demo;

public record Person(int id, String name) {
	
	public Person(String name) {
		this(0, name);
	}
	
	public Person {
		if (id < 0) {
			throw new IllegalArgumentException("id must not be negative");
		}
	}


}