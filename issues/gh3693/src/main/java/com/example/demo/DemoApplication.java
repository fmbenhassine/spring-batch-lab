package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

@EnableBatchProcessing
@SpringBootApplication
public class DemoApplication {

	public record Person (int id, String name) {
	}

	@Bean
	public FlatFileItemReader<Person> itemReader() {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personReader")
				.resource(new FileSystemResource("persons.csv"))
				.targetType(Person.class)
				.delimited()
				.names("id", "name")
				.build();
	}

	@Bean
	public ItemWriter<Person> itemWriter() {
		return items -> {
			for (Person person : items) {
				System.out.println(person);
			}
		};
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Person, Person>chunk(2)
						.reader(itemReader())
						.writer(itemWriter())
						.build())
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

