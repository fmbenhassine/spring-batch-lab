package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.RecordFieldSetMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class FileToFileJob {

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
				.names("name", "id")
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

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(FileToFileJob.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());
	}

}
