package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class DemoApplication {

	// when done, see the generated spy.log (format defined here: https://p6spy.readthedocs.io/en/latest/configandusage.html#logmessageformat)
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// from https://spring.io/guides/gs/accessing-data-jpa/
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Customer customer : repository.findAll()) {
				System.out.println(customer.toString());
			}
			System.out.println();

			// fetch customers by last name
			System.out.println("Customer found with findByLastName('foo50'):");
			System.out.println("--------------------------------------------");
			repository.findByLastName("foo50").forEach(System.out::println);
			System.out.println();
		};
	}
}
