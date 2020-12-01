package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProcessingError {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String cause;

	protected ProcessingError() {
	}

	public ProcessingError(String name, String cause) {
		this.name = name;
		this.cause = cause;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCause() {
		return cause;
	}

	@Override
	public String toString() {
		return "ProcessingError{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cause='" + cause + '\'' +
				'}';
	}
}
