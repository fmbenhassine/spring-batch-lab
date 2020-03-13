package com.example.demo;

public class Address {
	private int id;
	private String name;

	public Address(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Address() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
