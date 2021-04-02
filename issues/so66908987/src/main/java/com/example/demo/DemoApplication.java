package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>(Arrays.asList(args));
		strings.add("files=classpath:*.txt");
		SpringApplication.run(DemoApplication.class, strings.toArray(new String[0]));
	}

}
