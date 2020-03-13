package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Bean
	public ItemReader<String> itemReader() {
		List<String> items = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			items.add("foo" + i);
		}
		return new ListItemReader<>(items);
	}

	@Bean
	public ItemProcessor<String, String> itemProcessor() {
		return item -> {
			if (item.contains("1")) {
				throw new IllegalArgumentException();
			}
			return item;
		};
	}

	@Bean
	public ItemWriter<String> itemWriter() {
		return items -> {
			for (String item : items) {
				System.out.println("item = " + item);
			}
		};
	}
	
	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<String, String>chunk(10)
						.reader(itemReader())
						.processor(itemProcessor())
						.writer(itemWriter())
						.faultTolerant()
						.skip(IllegalArgumentException.class)
						.skipLimit(5)
						.taskExecutor(new SimpleAsyncTaskExecutor())
						.throttleLimit(10)
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
