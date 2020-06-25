package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		MongoTemplate mongoTemplate = applicationContext.getBean(MongoTemplate.class);

		MongoCollection<Document> personsCollection = mongoTemplate.getCollection("persons");
		personsCollection.deleteMany(new Document());
		MongoItemWriter<Person> mongoItemWriter = applicationContext.getBean(MongoItemWriter.class);
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			persons.add(new Person("foo" + i));
		}

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		mongoItemWriter.write(persons);

		stopWatch.stop();
		System.out.println("Total inserted documents: " + personsCollection.countDocuments());
		System.out.println("Total time: " + stopWatch.getTotalTimeSeconds() + "s");
	}

	@Bean
	public MongoItemWriter<Person> mongoItemWriter(MongoTemplate mongoTemplate) {
		return new MongoItemWriterBuilder<Person>()
				.template(mongoTemplate)
				.collection("persons")
				.build();
	}

}
