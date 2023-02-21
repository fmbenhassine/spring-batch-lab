package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;

@Configuration
@EnableBatchProcessing
public class MyJobConfig {

	@Bean
	@StepScope
	public FlatFileItemReader<String> itemReader() {
		return new FlatFileItemReaderBuilder<String>()
				.name("reader")
				.resource(new ByteArrayResource("hello\nworld".getBytes()))
				.lineMapper(new PassThroughLineMapper())
				.build();
	}

	@Bean
	public ItemWriter<String> itemWriter() {
		return items -> {
			for (String item : items) {
				System.out.println(item);
			}
		};
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("my-job-context.xml");
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());
	}

}
