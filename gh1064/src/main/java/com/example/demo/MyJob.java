package com.example.demo;

import java.io.InputStreamReader;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Bean
	public FlatFileItemReader<String> itemReader() {
		return new FlatFileItemReaderBuilder<String>()
				.name("fragmentReader")
				.resource(new ClassPathResource("data.txt"))
				.lineMapper(new PassThroughLineMapper())
				.bufferedReaderFactory((resource, encoding) ->
						new FixedLengthBufferedReader(new InputStreamReader(resource.getInputStream(), encoding)))
				.build();
	}

	@Bean
	public ItemWriter<String> itemWriter() {
		return items -> items.forEach(System.out::println);
	}
	
	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<String, String>chunk(2)
						.reader(itemReader())
						.writer(itemWriter())
						.build())
				.build();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());
	}

}
