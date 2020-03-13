/*
 * Copyright 2020 the original author or authors.
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

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.ReflectionUtils;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Bean
	public ItemReader<Person> itemReader() {
		List<Person> items = Arrays.asList(new Person(1, "foo"), new Person(2, "bar"));
		return new ListItemReader<>(items);
	}

// The method .delimited() has been added in v4.1
//	@Bean
//	public FlatFileItemWriter<Person> itemWriter() {
//		return new FlatFileItemWriterBuilder<Person>()
//				.name("personWriter")
//				.resource(new FileSystemResource("persons.txt"))
//				.delimited()
//				.names("id", "name") // uses a BeanWrapperFieldExtractor behind the scene, see Javadoc
//				.build();
//	}

	@Bean
	public FlatFileItemWriter<Person> itemWriter() {
		// Just make sure we are using a Person class which is instrumented by JaCoCo (can use javap -v as well)
		System.out.println("Checking fields in the Person class");
		ReflectionUtils.doWithFields(Person.class, field -> System.out.println(field.getName()));

		DelimitedLineAggregator<Person> lineAggregator = new DelimitedLineAggregator<>();
		lineAggregator.setDelimiter(",");

// Just making sure the field extractor is seeing the instrumented class as well
//		BeanWrapperFieldExtractor<Person> fieldExtractor = new BeanWrapperFieldExtractor<Person>() {
//			@Override
//			public Object[] extract(Person item) {
//				// Just make sure we are using a Person class instrumented by JaCoCo (can use javap -v as well)
//				System.out.println("Checking fields in the Person class");
//				ReflectionUtils.doWithFields(Person.class, field -> System.out.println(field.getName()));
//				return super.extract(item);
//			}
//		};

		BeanWrapperFieldExtractor<Person> fieldExtractor = new BeanWrapperFieldExtractor<>();
		// unless "$jacocoData" is added manually to the list of field names,
		// I don't see how it is possible to have the error with the built-in BeanWrapperFieldExtractor
		// since it will iterate only over the list of fields specified here
		fieldExtractor.setNames(new String[]{"id", "name"});
		lineAggregator.setFieldExtractor(fieldExtractor);
		return new FlatFileItemWriterBuilder<Person>()
				.name("personWriter")
				.resource(new FileSystemResource("persons.txt"))
				.lineAggregator(lineAggregator)
				.build();
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

}
