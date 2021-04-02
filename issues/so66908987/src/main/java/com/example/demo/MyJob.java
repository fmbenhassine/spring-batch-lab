package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineCallbackHandler;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class MyJob {
	
	@Bean
	public LineCallbackHandler lineCallbackHandler() {
		return new LineCallbackHandler() {
			// injecting the resource directly with
			// @Value("#{@itemReader.resource}") Resource currentResource;
			// does not work as the field is initialized only once
			@Value("#{@itemReader}")
			private FlatFileItemReader<String> reader;  
			@Override
			public void handleLine(String s) {
				System.out.println("skipping line '" + s + "' coming from " + reader.getResource().getFilename());
			}
		};
	}
	
	@Bean
	public FlatFileItemReader<String> itemReader() {
		return new FlatFileItemReaderBuilder<String>()
				.name("itemReader")
				.lineMapper(new PassThroughLineMapper())
				.linesToSkip(1)
				.skippedLinesCallback(lineCallbackHandler())
				.build();
	}

	@Bean
	@StepScope
	public MultiResourceItemReader<String> multiResourceItemReader(@Value("#{jobParameters['files']}") Resource[] resources) {
		return new MultiResourceItemReaderBuilder<String>()
				.name("multiResourceItemReader")
				.resources(resources)
				.delegate(itemReader())
				.build();
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<String, String>chunk(5)
						.reader(multiResourceItemReader(null))
						.writer(items -> items.forEach(System.out::println))
						.build())
				.build();
	}

}