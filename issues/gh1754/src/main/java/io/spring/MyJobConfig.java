package io.spring;

import java.io.Writer;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import io.micrometer.core.instrument.util.StringUtils;
import javanet.staxutils.IndentingXMLEventWriter;
import javanet.staxutils.helpers.EventWriterDelegate;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
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
public class MyJobConfig {

	private final JobBuilderFactory jobBuilderFactory;

	private final StepBuilderFactory stepBuilderFactory;

	public MyJobConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public ItemReader<Person> itemReader() {
		return new ListItemReader<>(Arrays.asList(
				new Person(1, "foo"),
				new Person(2, "bar"))
		);
	}

	@Bean
	public ItemWriter<Person> itemWriter() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Person.class);
		StaxEventItemWriter<Person> writer = new StaxEventItemWriter<Person>() {
			@Override
			protected XMLEventWriter createXmlEventWriter(XMLOutputFactory outputFactory, Writer writer) throws XMLStreamException {
				XMLEventWriter eventWriter = super.createXmlEventWriter(outputFactory,writer);
				IndentingXMLEventWriter indentingXMLEventWriter = new IndentingXMLEventWriter(eventWriter);
				return new XMLEventWriterFilteringBlankCharacterEvents(indentingXMLEventWriter);
			}
		};
		writer.setName("personWriter");
		writer.setRootTagName("persons");
		writer.setResource(new FileSystemResource("persons.xml"));
		writer.setMarshaller(marshaller);
		return writer;
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("step")
				.<Person, Person>chunk(5)
				.reader(itemReader())
				.writer(itemWriter())
				.build();
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job")
				.start(step())
				.build();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyJobConfig.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());
	}

	@XmlRootElement
	public static class Person {

		private int id;
		private String name;

		public Person(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public Person() {
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	static class XMLEventWriterFilteringBlankCharacterEvents extends EventWriterDelegate {

		public XMLEventWriterFilteringBlankCharacterEvents(XMLEventWriter out) {
			super(out);
		}

		public void add(XMLEvent event) throws XMLStreamException {
			if ( event.getEventType() == XMLStreamConstants.CHARACTERS ) {
				Characters characters = event.asCharacters();
				if ( StringUtils.isBlank(characters.getData()) ) {
					return;
				}
			}
			super.add(event);
		}
	}

}