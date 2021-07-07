package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class BulkConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public FlatFileItemReader<Person> reader1() {
        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>() {
            @Override
            public Person read() throws Exception {
                System.out.println("Thread running when invoking the reader: " + Thread.currentThread().getName());
                return super.read();
            }
        };
        reader.setLinesToSkip(1);
        reader.setResource(new FileSystemResource("persons.csv"));

        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

        String[] names = {"firstname", "lastname", "age"};
        tokenizer.setNames(names);

        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        lineMapper.afterPropertiesSet();

        reader.setLineMapper(lineMapper);
        reader.setSaveState(false);
        System.out.println("Thread running when configuring the reader bean: " + Thread.currentThread().getName());
        return reader;

    }

    @Bean
    @StepScope
    public ItemProcessor<Person, Person1> processor1() {
        return new EnrichmentProcessor();
    }

    @Bean
    @StepScope
    public ItemWriter<Person1> writer() {
        return new FileUploader();
    }


    @Bean
    public Step load() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(3);
        threadPoolTaskExecutor.setCorePoolSize(3);
        threadPoolTaskExecutor.afterPropertiesSet();

        return this.stepBuilderFactory.get("load")
                .<Person, Person1>chunk(2)
                .reader(reader1())
                .processor(processor1())
                .writer(writer())
                .taskExecutor(threadPoolTaskExecutor)
                .build();
    }


    @Bean(name = "uploadJob")
    public Job cmUploadJob() {
        return this.jobBuilderFactory.get("uploadJob")
                .start(load())
                .build();
    }
}