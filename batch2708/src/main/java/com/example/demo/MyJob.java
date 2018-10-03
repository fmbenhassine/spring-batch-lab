package com.example.demo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
public class MyJob {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	public XStreamMarshaller xStreamMarshaller() {
		XStreamMarshaller xStreamMarshaller = new XStreamMarshaller() {
			@Override
			protected void customizeXStream(XStream xstream) {
				xstream.alias("person", Person.class);
				xstream.addPermission(NoTypePermission.NONE); // removing this leads to: "Security framework of XStream not initialized, XStream is probably vulnerable."
				xstream.allowTypes(new Class[] {Person.class}); // removing this or setting it to Foo.class leads to: "com.thoughtworks.xstream.security.ForbiddenClassException: com.example.demo.Person" which means it works as expected
			}
		};
//		xStreamMarshaller.getXStream().alias("person", Person.class); // does not work (as expected) as getXStream should not be used for configuration. See its Javadoc
		return xStreamMarshaller;
	}

	@Bean
	public StaxEventItemReader<Person> itemReader() {
		return new StaxEventItemReaderBuilder<Person>()
				.name("personReader")
				.resource(new ClassPathResource("persons.xml"))
				.addFragmentRootElements("person")
				.unmarshaller(xStreamMarshaller())
				.build();
	}

	@Bean
	public ItemWriter<Person> itemWriter() {
		return items -> {
			for (Person person : items) {
				System.out.println("person = " + person);
			}
		};
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<Person, Person>chunk(1)
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
