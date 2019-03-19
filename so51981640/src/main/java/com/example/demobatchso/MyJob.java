package com.example.demobatchso;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	public ItemReader<Integer> itemReader() {
		return new ListItemReader<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	}

	@Bean
	public ItemWriter<Integer> itemWriter() {
		return items -> {
			for (Integer item : items) {
				System.out.println(Thread.currentThread().getName() + "item = " + item);
			}
		};
	}

	@Bean
	public ItemProcessor<Integer, Integer> itemProcessor() {
		return item -> {
			if (item.equals(7)) {
				throw new IllegalArgumentException("Sevens are not accepted!!");
			}
			return item;
		};
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<Integer, Integer>chunk(5)
				.reader(itemReader())
				.processor(itemProcessor())
				.writer(itemWriter())
				.faultTolerant()
				.skip(IllegalArgumentException.class)
				.skipLimit(3)
				.listener(new MySkipListener())
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step())
				.build();
	}

}
