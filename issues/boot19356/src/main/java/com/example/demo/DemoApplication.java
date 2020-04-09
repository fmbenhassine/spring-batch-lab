package com.example.demo;

import java.util.Arrays;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;

// Need to have a mongodb server up and running on default host:port.
// docker run --name mongodb --rm -d -p 27017:27017 mongo

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	@Order(-1) // make sure this runs before JobLauncherApplicationRunner
	public ApplicationRunner dbInitRunner(MongoTemplate mongoTemplate) {
		return args -> {
			MongoCollection<Document> personsIn = mongoTemplate.getCollection("person_in");
			MongoCollection<Document> personsOut = mongoTemplate.getCollection("person_out");
			personsIn.deleteMany(new Document());
			personsOut.deleteMany(new Document());
			personsIn.insertMany(Arrays.asList(
					new Document("name", "foo1"),
					new Document("name", "foo2"),
					new Document("name", "foo3"),
					new Document("name", "foo4"))
			);
		};
	}

}
