package com.example.demo.writer;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

public class PersonItemWriter implements ItemWriter<Person> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonItemWriter.class);

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    Environment env;

    @Override
    public void write(List<? extends Person> personEntitiesList) throws Exception {
        LOGGER.info("About to write Person entities to [{}] database...", env.getActiveProfiles());
        long start = System.currentTimeMillis();

        personRepository.saveAll(personEntitiesList);

        long end = System.currentTimeMillis();
        LOGGER.info("Finished writing Person entities to [{}] database in {} milliseconds...",
                env.getActiveProfiles(), end-start);
    }
}
