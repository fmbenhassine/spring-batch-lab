package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

@EnableBatchProcessing
@SpringBootApplication
public class DemoApplication {

	@Bean
	public FlatFileItemReader<Person> itemReader() {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personReader")
				.resource(new FileSystemResource("persons.csv"))
				.delimited()
				.names("id", "name")
				.fieldSetMapper(new RecordFieldSetMapper<>(Person.class))
				.build();
	}

	@Bean
	public FlatFileItemWriter<Person> itemWriter() {
		return new FlatFileItemWriterBuilder<Person>()
				.name("personWriter")
				.resource(new FileSystemResource("persons-out.csv"))
				.delimited()
				.fieldExtractor(new RecordFieldExtractor<>(Person.class) {{ setNames("name", "id");}})
				.build();
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

