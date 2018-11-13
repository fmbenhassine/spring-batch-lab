/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.ResourceAwareItemWriterItemStream;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.util.ExecutionContextUserSupport;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;

@Configuration
public class MyJob {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public ItemReader<Person> itemReader() {
		List<Person> persons = Arrays.asList(new Person(1, "foo"), new Person(2, "bar"));
		return new ListItemReader<>(persons);
	}

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Person.class);
		Map<String, Object> properties = new HashMap<>();
		// I'm expecting that just by adding this, the output xml would be pretty printed
		properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setMarshallerProperties(properties);
		return marshaller;
	}

	@Bean
	public StaxEventItemWriter<Person> itemWriter() {
		StaxEventItemWriter<Person> itemWriter = new StaxEventItemWriter<Person>();
//		StaxEventItemWriter<Person> itemWriter = new StaxEventItemWriter<Person>() {
//			@Override
//			protected Result createStaxResult() {
//				return new StreamResult(bufferedWriter); // if bufferedWriter was protected
//			}
//		};
		itemWriter.setRootTagName("persons");
		itemWriter.setResource(new FileSystemResource("persons.xml"));
		itemWriter.setMarshaller(marshaller());
		return itemWriter;
	}

	/* bean from the example attached in jira */
//	@Bean
//	public XmlItemWriter<Person> xmlItemWriter() {
//		XmlItemWriter<Person> itemWriter = new XmlItemWriter<>();
//		itemWriter.setRootTagName("persons");
//		itemWriter.setResource(new FileSystemResource("persons.xml"));
//		itemWriter.setMarshaller(marshaller());
//		return itemWriter;
//	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<Person, Person>chunk(5)
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

	@XmlRootElement
	public static class Person {
		private int id;
		private String name;
		public Person() {
		}
		public Person(int id, String name) {
			this.id = id;
			this.name = name;
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

	/* from the file attached in jira */
	public class XmlItemWriter<T> extends ExecutionContextUserSupport implements
			ResourceAwareItemWriterItemStream<T>, InitializingBean {

		private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";

		private static final int BUFFER_SIZE = 1024 * 32;

		private Resource resource;

		private org.springframework.oxm.Marshaller marshaller;

		private String rootTagName;

		/**
		 * Used to write characters to the provided resource.
		 */
		private BufferedWriter writer;

		/**
		 * Create a new instance.
		 */
		public XmlItemWriter() {
			setName(ClassUtils.getShortName(XmlItemWriter.class));
		}

		public void afterPropertiesSet() throws Exception {
//			Validate.notNull(resource, "property 'resource' must not be null");
//			Validate.notNull(marshaller, "property 'marshaller' must not be null");
//			Validate.notNull(rootTagName, "property 'rootTagName' must not be null");
		}

		public void open(ExecutionContext executionContext)
				throws ItemStreamException {
			try {
				writer = new BufferedWriter(new FileWriter(resource.getFile()),
						BUFFER_SIZE);
				writer.write(XML_HEADER);
				writer.newLine();
				writer.write("<");
				writer.write(rootTagName);
				writer.write(">");
				writer.newLine();
			} catch (IOException e) {
				new ItemStreamException("Failed to write header.", e);
			}

		}

		public void update(ExecutionContext executionContext)
				throws ItemStreamException {
			// nothing to do here!
		}

		public void close() throws ItemStreamException {
			try {
				writer.write("</");
				writer.write(rootTagName);
				writer.write(">");
				writer.newLine();
				writer.close();
			} catch (IOException e) {
				new ItemStreamException("Failed to write footer,", e);
			}

		}

		public void write(List<? extends T> items) throws Exception {
			Result result = new StreamResult(writer);
			for (T item : items) {
				marshaller.marshal(item, result);
				writer.newLine();
			}
			writer.flush(); // chunk is written for sure
		}

		public void setResource(Resource resource) {
			this.resource = resource;

		}

		/**
		 * Set the marshaller used to transform a object graph to XML.
		 *
		 * @param marshaller
		 *            the marshaller to use.
		 */
		public void setMarshaller(org.springframework.oxm.Marshaller marshaller) {
			this.marshaller = marshaller;
		}

		/**
		 * Set the name of the root element of the XML document to create.
		 *
		 * @param rootTagName
		 *            the name of the XML root element.
		 */
		public void setRootTagName(String rootTagName) {
			this.rootTagName = rootTagName;
		}

	}

}
