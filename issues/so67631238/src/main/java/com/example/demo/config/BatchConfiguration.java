package com.example.demo.config;

import com.example.demo.domain.Person;
import com.example.demo.writer.PersonItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public FlatFileItemReader<Person> reader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("csvResourceFileItemReader")
                .resource(new ClassPathResource("sample-data.csv"))
                .delimited()
                .names(new String[]{"firstName", "lastName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                    setTargetType(Person.class);
                }})
                .build();
    }

    @Bean
    public ItemWriter<Person> writer() {
        return new PersonItemWriter();
    }

    @Bean(name = "jobToLoadDataFromCsv")
    public Job jobToLoadDataFromCsv(PlatformTransactionManager transactionManager,
                                    TaskExecutor taskExecutor) {
        return jobBuilderFactory.get("jobToLoadDataFromCsv")
                .start(stepToLoadDataFromCsv(transactionManager, taskExecutor))
                .build();
    }

    // Seems to be the problem
    // If I comment out this taskExecutor method and comment it out in the
    // "stepToLoadDataFromCsv" step method, Spring >= 2.2.1 versions seem to persist data fine
    @Bean
    @StepScope
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(1);
        threadPoolExecutor.setThreadGroupName("taskExecutor-batch");
        return threadPoolExecutor;
    }

    @Bean(name = "stepToLoadDataFromCsv")
    public Step stepToLoadDataFromCsv(PlatformTransactionManager transactionManager,
                                      TaskExecutor taskExecutor) {
        TaskletStep step = stepBuilderFactory.get("stepToLoadDataFromCsv")
                .<Person,Person>chunk(250)
                .reader(reader())
                .writer(writer())
                .faultTolerant()
                .skipPolicy(new AlwaysSkipItemSkipPolicy())
                .skip(Exception.class)
                .taskExecutor(taskExecutor)// seems to be problem
                .throttleLimit(1)
                .build();
        step.setTransactionManager(transactionManager);
        return step;
    }
}