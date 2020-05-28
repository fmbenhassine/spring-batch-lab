package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class RepositoryItemWriterPerformance {

	@Bean
	public FlatFileItemReader<Person> itemReader() {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personItemReader")
				.resource(new FileSystemResource("persons.csv"))
				.delimited()
				.names("id", "name")
				.targetType(Person.class)
				.build();
	}

	@Bean
	public RepositoryItemWriter<Person> itemWriter(PersonRepository personRepository) {
		return new RepositoryItemWriterBuilder<Person>()
				.repository(personRepository)
				.methodName("save")
				.build();
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Person, Person>chunk(1000)
						.reader(itemReader())
						.writer(itemWriter(null))
						.build())
				.build();
	}

}