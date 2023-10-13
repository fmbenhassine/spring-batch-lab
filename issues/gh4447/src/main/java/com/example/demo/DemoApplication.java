package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner dbInitializer(CustomerRepository repository) {
		return new DbInitializer(repository);
	}

	static class DbInitializer implements CommandLineRunner, Ordered {

		private final CustomerRepository repository;

		DbInitializer(CustomerRepository repository) {
			this.repository = repository;
		}

		// from https://spring.io/guides/gs/accessing-data-jpa/
		@Override
		public void run(String... args) throws Exception {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Hamilton"));
			repository.save(new Customer("Michelle", "Dessler"));
			repository.save(new Customer("Tom", "Hanks"));
			repository.save(new Customer("Daniel", "Craig"));

			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Customer customer : repository.findAll()) {
				System.out.println(customer.toString());
			}
			System.out.println();

			// fetch customers by first name
			System.out.println("Customer found with findByFirstName('David'):");
			System.out.println("--------------------------------------------");
			repository.findByFirstName("David").forEach(System.out::println);
			System.out.println();

			// fetch customers by last name
			System.out.println("Customer found with findByLastName('Bauer'):");
			System.out.println("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(System.out::println);
			System.out.println();
		}

		@Override
		public int getOrder() {
			return -1; // make sure this runner is executed before the JobLauncherCommandLineRunner (which has a default order of 0)
		}
	}
}
