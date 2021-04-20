package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@EnableBatchProcessing
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ListItemReader<Person> itemReader() {
        return new ListItemReader<>(Arrays.asList(
                new Person(1, "foo1"), new Person(2, "foo2"),
                new Person(3, "foo3"), new Person(4, "foo4")
        ));
    }

    @Bean
    public FlatFileItemWriter<Person> itemWriter() {
        FlatFileItemWriter<Person> flatFileItemWriter = new FlatFileItemWriter<Person>() {
            @Override
            public String doWrite(List<? extends Person> items) {
                StringBuilder lines = new StringBuilder();
                Iterator<? extends Person> iterator = items.iterator();
                while (iterator.hasNext()) {
                    Person person = iterator.next();
                    lines.append(lineAggregator.aggregate(person));
                    if (iterator.hasNext()) {
                        lines.append(lineSeparator);
                    }
                }
                return lines.toString();
            }
        };
        flatFileItemWriter.setResource(new FileSystemResource("persons.csv"));
        flatFileItemWriter.setName("personItemWriter");
        DelimitedLineAggregator<Person> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");
        lineAggregator.setFieldExtractor(new BeanWrapperFieldExtractor<Person>() {{
            setNames(new String[]{"id", "name"});
        }});
        flatFileItemWriter.setLineAggregator(lineAggregator);
        return flatFileItemWriter;
    }

    @Bean
    public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
        return jobs.get("job")
                .start(steps.get("step")
                        .<Person, Person>chunk(2)
                        .reader(itemReader())
                        .writer(itemWriter())
                        .build())
                .build();
    }

}
