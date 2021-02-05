package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class MultiResourcePartitionerSample {

	@Value("file:input/userdata*.txt")
	private Resource[] resources;

	@Bean
	public MultiResourcePartitioner partitioner() {
		MultiResourcePartitioner partitioner = new MultiResourcePartitioner();
		partitioner.setResources(resources);
		return partitioner;
	}

	@StepScope
	@Bean
	public FlatFileItemReader<String> personFileReader(@Value("#{stepExecutionContext['fileName']}") Resource resource) {
		return new FlatFileItemReaderBuilder<String>()
				.name("itemReader")
				.resource(resource)
				.lineMapper(new PassThroughLineMapper())
				.build();
	}

	@Bean
	public Step managerStep(StepBuilderFactory stepBuilderFactory) {
		Step workerStep = workerStep(stepBuilderFactory);
		return stepBuilderFactory.get("managerStep")
				.partitioner(workerStep.getName(), partitioner())
				.step(workerStep)
				.taskExecutor(new SimpleAsyncTaskExecutor())
				.build();
	}
	
	@Bean
	public Step workerStep(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("workerStep")
				.<String, String>chunk(5)
				.reader(personFileReader(null))
				.writer(items -> items.forEach(System.out::println))
				.build();
	}

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		return jobBuilderFactory.get("job")
				.start(managerStep(stepBuilderFactory))
				.build();
	}

}