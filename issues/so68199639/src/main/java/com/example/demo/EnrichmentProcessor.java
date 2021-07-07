package com.example.demo;

import org.springframework.batch.item.ItemProcessor;

public class EnrichmentProcessor implements ItemProcessor<Person, Person1> {
    @Override
    public Person1 process(Person person) throws Exception {
        Person1 person1 = new Person1();
        person1.setFirstname(person.getFirstname().toUpperCase());
        person1.setLastname(person.getLastname().toUpperCase());
        person1.setAge(person.getAge());

        if (person.getFirstname().equals("zxcv")) {
            throw new RuntimeException("Error occurred in thread " + Thread.currentThread().getName());
        }

        return person1;
    }
}