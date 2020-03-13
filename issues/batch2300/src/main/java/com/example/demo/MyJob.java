package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class MyJob {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

@Bean
public StaxEventItemReader<Paragraph> itemReader() {
	Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	marshaller.setClassesToBeBound(Paragraph.class);

	return new StaxEventItemReaderBuilder<Paragraph>()
			.name("paragraphReader")
			.resource(new ClassPathResource("index.html"))
			.addFragmentRootElements("p")
			.unmarshaller(marshaller)
			.build();
}

	@Bean
	public ItemWriter<Paragraph> itemWriter() {
		return items -> {
			for (Paragraph paragraph : items) {
				System.out.println(paragraph);
			}
		};
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<Paragraph, Paragraph>chunk(2)
				.reader(itemReader())
				.writer(itemWriter())
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step())
				.build();
	}

}
