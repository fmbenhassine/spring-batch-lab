package io.spring;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Job1Configuration {

	private final Random random;
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	public Job1Configuration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		this.random = new Random();
	}

	@Bean
	public Job job1() {
		return jobBuilderFactory.get("job1")
				.start(step1())
				.next(step2())
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("hello");
					// simulate processing time
					Thread.sleep(random.nextInt(3000));
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("world");
					// simulate step failure
					int nextInt = random.nextInt(3000);
					Thread.sleep(nextInt);
					if (nextInt % 5 == 0) {
						throw new Exception("Boom!");
					}
					return RepeatStatus.FINISHED;
				})
				.build();
	}

}
