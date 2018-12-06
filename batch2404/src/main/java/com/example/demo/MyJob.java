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

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DefaultFieldSet;
import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.BindException;

@Configuration
public class MyJob {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	/*
	 * Goal of the feature requested in BATCH-2404: do not trim values without implementing FieldSetMapper (imagine a domain object with dozens of fields..)
	 */

	/*
	 * Solution 1: Use a custom FieldSetMapper (this is *not* the goal: imagine a domain object with dozens
	 * (sometimes hundreds) of fields which is pretty common in production..)
	 */
/*	@Bean
	public FlatFileItemReader<Person> itemReader() {
		return new FlatFileItemReaderBuilder<Person>()
				.name("reader")
				.resource(new ClassPathResource("persons.csv"))
				.delimited()
				.names(new String[]{"firstName", "lastName"})
				.fieldSetMapper(fieldSet -> {
					Person person = new Person();
					person.setFirstName(fieldSet.readRawString("firstName"));
					person.setLastName(fieldSet.readRawString("lastName"));
					return person;
				})
				.build();
	}*/

	/*
	 * Solution 2: Use a custom FieldSetFactory that returns an extension of
	  * DefaultFieldSet that does not trim values (suggested in BATCH-2637)
	 */
/*	@Bean
	public FlatFileItemReader<Person> itemReader() {
		class NotTrimmingFieldSet extends DefaultFieldSet {

			NotTrimmingFieldSet(String[] tokens) {
				super(tokens);
			}

			NotTrimmingFieldSet(String[] tokens, String[] names) {
				super(tokens, names);
			}

			@Override
			protected String readAndTrim(int index) {
				return readRawString(index);
			}
		}
		return new FlatFileItemReaderBuilder<Person>()
				.name("reader")
				.resource(new ClassPathResource("persons.csv"))
				.delimited()
				.fieldSetFactory(new DefaultFieldSetFactory() {
					@Override
					public FieldSet create(String[] values, String[] names) {
						return new NotTrimmingFieldSet(values, names);
					}

					@Override
					public FieldSet create(String[] values) {
						return new NotTrimmingFieldSet(values);
					}
				})
				.names(new String[]{"firstName", "lastName"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{ setTargetType(Person.class);}})
				.build();
	}*/

	/*
	 * Solution 3: Extend BeanWrapperFieldSetMapper and use FieldSet#readRawString
	 * only for fields that need to be mapped in raw format
	 */
	@Bean
	public FlatFileItemReader<Person> itemReader() {
		BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<Person>() {
			@Override
			public Person mapFieldSet(FieldSet fs) throws BindException {
				Person person = super.mapFieldSet(fs);
				person.setLastName(fs.readRawString("lastName"));
				return person;
			}
		};
		fieldSetMapper.setTargetType(Person.class);

		return new FlatFileItemReaderBuilder<Person>()
				.name("reader")
				.resource(new ClassPathResource("persons.csv"))
				.delimited()
				.names(new String[]{"firstName", "lastName"})
				.fieldSetMapper(fieldSetMapper)
				.build();
	}
	
	@Bean
	public ItemWriter<Person> itemWriter() {
		return items -> {
			for (Person item : items) {
				System.out.println("item = " + item);
			}
		};
	}

	@Bean
	public Step step() {
		return steps.get("step")
				.<Person, Person>chunk(2)
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
