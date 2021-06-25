package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class MyJobConfiguration {

	@Bean
	public MultiResourceItemReader<String> itemReader() {
		FlatFileItemReader<String> itemReader = new FlatFileItemReaderBuilder<String>()
				.name("itemReader")
				.lineMapper(new PassThroughLineMapper())
				.build();

		MultiResourceItemReader<String> multiResourceItemReader = new MultiResourceItemReader<>();
		multiResourceItemReader.setDelegate(itemReader);
		Resource resource1 = new FileSystemResource("file1.txt");
		Resource resource2 = new FileSystemResource("file2.txt");
		multiResourceItemReader.setResources(new Resource[] {resource1, resource2});
		return multiResourceItemReader;
	}

	@Bean
	public ItemWriter<String> itemWriter() {
		return items -> items.forEach(System.out::println);
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<String, String>chunk(5)
						.reader(itemReader())
						.writer(itemWriter())
						.build())
				.build();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyJobConfiguration.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());
	}

}
