package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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
	public CommandLineRunner dbInitializer(EntityManagerFactory factory) {
		return new DbInitializer(factory);
	}

	class DbInitializer implements CommandLineRunner, Ordered {

		private EntityManagerFactory factory;

		DbInitializer(EntityManagerFactory factory) {
			this.factory = factory;
		}

		@Override
		public void run(String... args) {
			// save a couple of customers
			EntityManager entityManager = factory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(new Customer("Jack", "Bauer"));
			entityManager.persist(new Customer("Chloe", "O'Brian"));
			entityManager.persist(new Customer("David", "Palmer"));
			entityManager.persist(new Customer("Kim", "Bauer"));
			entityManager.persist(new Customer("David", "Hamilton"));
			entityManager.persist(new Customer("Michelle", "Dessler"));
			entityManager.persist(new Customer("Tom", "Hanks"));
			entityManager.persist(new Customer("Daniel", "Craig"));
			entityManager.flush();
			transaction.commit();
			entityManager.clear();
			entityManager.close();
			System.out.println("DbInitializer inserted customers");
		}

		@Override
		public int getOrder() {
			return -1; // make sure this runner is executed before the JobLauncherCommandLineRunner (which has a default order of 0)
		}
	}
}
