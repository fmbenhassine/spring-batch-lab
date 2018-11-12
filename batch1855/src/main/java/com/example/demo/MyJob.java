package com.example.demo;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.SimpleBinaryBufferedReaderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ByteArrayResource;

@Configuration
public class MyJob {

	private static final Charset ENCODING = StandardCharsets.UTF_8;

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public FlatFileItemReader<byte[]> itemReader() {
		byte[] inputData = "1,foo\n2,bar\n".getBytes(ENCODING);
		FlatFileItemReader<byte[]> itemReader = new FlatFileItemReader<>();
		itemReader.setName("bytesItemReader");
		itemReader.setResource(new ByteArrayResource(inputData));
		itemReader.setLineMapper((line, lineNumber) -> line.getBytes());
		itemReader.setBufferedReaderFactory(new SimpleBinaryBufferedReaderFactory());
		itemReader.setEncoding(ENCODING.name());
		return itemReader;
	}

	@Bean
	public ItemWriter<byte[]> itemWriter() {
		return items -> {
			for (byte[] item : items) {
				System.out.println(Arrays.toString(item));
			}
		};
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<byte[], byte[]>chunk(2)
				.reader(itemReader())
				.writer(itemWriter())
				.faultTolerant()
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step())
				.build();
	}

}
