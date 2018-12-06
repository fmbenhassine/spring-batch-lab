package com.example.demo;

public class Person {

	private String firstName, LastName;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		LastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "Person{" +
				"firstName='" + firstName + '\'' +
				", LastName='" + LastName + '\'' +
				'}';
	}
}
