package io.spring;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Job2Configuration {

	private final Random random;
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	public Job2Configuration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		this.random = new Random();
	}

	@Bean
	public Job job2() {
		return jobBuilderFactory.get("job2")
				.start(step())
				.build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("step1")
				.<Integer, Integer>chunk(3)
				.reader(itemReader())
				.writer(itemWriter())
				.build();
	}

	@Bean
	@StepScope
	public ListItemReader<Integer> itemReader() {
		List<Integer> items = new LinkedList<>();
		// read a random number of items in each run
		for (int i = 0; i < random.nextInt(100); i++) {
			items.add(i);
		}
		return new ListItemReader<>(items);
	}

	@Bean
	public ItemWriter<Integer> itemWriter() {
		return items -> {
			for (Integer item : items) {
				int nextInt = random.nextInt(1000);
				Thread.sleep(nextInt);
				// simulate write failure
				if (nextInt % 57 == 0) {
					throw new Exception("Boom!");
				}
				System.out.println("item = " + item);
			}
		};
	}

}
