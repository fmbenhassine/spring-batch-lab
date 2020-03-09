package com.example.demo;

import java.util.Arrays;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Bean
	public ItemReader<Person> itemReader() {
		List<Person> persons = Arrays.asList(new Person("foo"), new Person("bar"));
		return new ListItemReader<>(persons);
	}

	// works with Java 9+, there is a bug in Java 8, see https://bugs.openjdk.java.net/browse/JDK-8139584
	@Bean
	public StaxEventItemWriter<Person> itemWriter() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Person.class);
		StaxEventItemWriter<Person> itemWriter = new StaxEventItemWriter<Person>() {
			@Override
			protected void startDocument(XMLEventWriter writer) throws XMLStreamException {
				XMLEventFactory xmlEventFactory = createXmlEventFactory();
				writer.add(xmlEventFactory.createStartDocument(DEFAULT_ENCODING, DEFAULT_XML_VERSION, true));
				writer.add(xmlEventFactory.createStartElement(getRootTagNamespacePrefix(), getRootTagNamespace(), getRootTagName()));
			}
		};
		itemWriter.setName("personsWriter");
		itemWriter.setRootTagName("persons");
		itemWriter.setResource(new FileSystemResource("persons.xml"));
		itemWriter.setMarshaller(marshaller);
		return itemWriter;
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Person, Person>chunk(5)
						.reader(itemReader())
						.writer(itemWriter())
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
