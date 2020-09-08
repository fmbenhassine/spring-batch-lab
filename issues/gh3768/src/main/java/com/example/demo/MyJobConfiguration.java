package com.example.demo;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJobConfiguration {

	@Bean
	@StepScope
	public ItemReader<Integer> itemReader() {
		return new ListItemReader<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
	}

	@Bean
	@JobScope
	public ItemProcessor<Integer, Integer> itemProcessor() {
		return item -> item + 1;
	}

	@Bean
	@StepScope
	public ItemWriter<Integer> itemWriter() {
		return items -> {
			for (Integer item : items) {
				System.out.println("item = " + item);
			}
		};
	}
	
	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step1")
						.tasklet(tasklet(null))
						.build())
				.next(steps.get("step2")
						.<Integer, Integer>chunk(5)
						.reader(itemReader())
						.processor(itemProcessor())
						.writer(itemWriter())
						.build())
				.build();
	}

	@Bean
	@StepScope
	public Tasklet tasklet(@Value("#{jobParameters['name']}") String name) {
		return (contribution, chunkContext) -> {
			System.out.println("hello " + name);
			return RepeatStatus.FINISHED;
		};
	}

}