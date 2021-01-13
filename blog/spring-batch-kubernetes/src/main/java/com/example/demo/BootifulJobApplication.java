package com.example.demo;

import java.net.MalformedURLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@SpringBootApplication
@EnableBatchProcessing
public class BootifulJobApplication {

	public static void main(String[] args) {
		System.exit(
				SpringApplication.exit(
						SpringApplication.run(BootifulJobApplication.class, args)
				)
		);
	}
	
	@Bean
	@StepScope
	public Resource resource(@Value("#{jobParameters['fileName']}") String fileName) throws MalformedURLException {
		return new UrlResource(fileName);
	}

	@Bean

	public FlatFileItemReader<Person> itemReader(Resource resource)  {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personItemReader")
				.resource(resource)
				.delimited()
				.names("firstName", "lastName")
				.targetType(Person.class)
				.build();
	}

	@Bean
	public JdbcBatchItemWriter<Person> itemWriter(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Person>()
				.dataSource(dataSource)
				.sql("INSERT INTO PEOPLE (FIRST_NAME, LAST_NAME) VALUES (:firstName, :lastName)")
				.beanMapped()
				.build();
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps,
				   DataSource dataSource, Resource resource) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Person, Person>chunk(3)
						.reader(itemReader(resource))
						.writer(itemWriter(dataSource))
						.build())
				.build();
	}

}
