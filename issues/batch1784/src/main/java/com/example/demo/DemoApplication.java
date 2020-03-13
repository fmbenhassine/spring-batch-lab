package com.example.demo;

import org.springframework.batch.core.launch.JobOperator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		JobOperator jobOperator = context.getBean(JobOperator.class);

		for (int i = 0; i < 100_000; i++) {
			jobOperator.startNextInstance("job");
			System.out.println("i = " + i);
		}

		System.out.println("Done");
	}

}
