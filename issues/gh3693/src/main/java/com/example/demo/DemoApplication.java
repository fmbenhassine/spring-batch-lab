package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

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
				.targetType(Person.class)
				// should be transparent, no need to set a field set mapper (if target type is record => RecordFieldSetMapper)
//				.fieldSetMapper(new RecordFieldSetMapper<>(Person.class))
				.build();
	}

	@Bean
	public FlatFileItemWriter<Person> itemWriter() {
		return new FlatFileItemWriterBuilder<Person>()
				.name("personWriter")
				.resource(new FileSystemResource("persons-out.csv"))
				.delimited()
				.names("name", "id")
				// should be transparent, no need to set a field extractor (if target type is record => RecordFieldExtractor)
//				.fieldExtractor(new RecordFieldExtractor<>(Person.class) {{ setNames("name", "id");}})
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

