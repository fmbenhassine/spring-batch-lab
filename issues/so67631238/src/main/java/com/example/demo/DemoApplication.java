package com.example.demo;

import java.util.List;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

		PersonRepository personRepository = applicationContext.getBean(PersonRepository.class);
		List<Person> personList = personRepository.findAll();
		for (Person person : personList) {
			System.out.println("person = " + person);
		}
	}

}
