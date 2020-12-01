package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			CustomerRepository customerRepository,
			ProcessingErrorRepository processingErrorRepository) {
		return args -> {
			
			System.out.println("Customers:");
			System.out.println("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				System.out.println(customer);
			}

			System.out.println("Processing errors:");
			System.out.println("-------------------------------");
			for (ProcessingError processingError : processingErrorRepository.findAll()) {
				System.out.println(processingError);
			}
		};
	}
}
