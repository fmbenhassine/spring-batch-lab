package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.model.Person;
import com.example.demo.model.Works;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

public class DemoApplication {

	public static void main(String[] args) throws Exception {
		Map<String,String> aliasesMap = new HashMap<>();
		aliasesMap.put("person", "com.example.demo.model.Person");
		aliasesMap.put("works", "com.example.demo.model.Works");
		aliasesMap.put("Work", "com.example.demo.model.Work");
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAliases(aliasesMap);
		Map<Class<?>, String> implicitCollections = new HashMap<>();
		implicitCollections.put(Works.class, "Work");
		marshaller.setImplicitCollections(implicitCollections);

		StaxEventItemReader<Person> reader = new StaxEventItemReader<>();
		reader.setUnmarshaller(marshaller);
		reader.setFragmentRootElementName("person");
		reader.setResource(new ClassPathResource("persons.xml"));

		reader.open(new ExecutionContext());
		Person person = reader.read();
		System.out.println("person = " + person);
		reader.close();
	}

}
