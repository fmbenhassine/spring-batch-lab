package com.example.demo;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@Import(InfrastructureConfiguration.class)
public class DistributedBatchJobConfiguration {

    @Bean
    public ListItemReader<Person> itemReader() {
        return new ListItemReader<>(Arrays.asList(
                new Person(1, "foobar1"),
                new Person(2, "foobar2"),
                new Person(3, "foobar3"),
                new Person(4, "foooobaaaar4") // this will cause the second chunk to fail (since the type of the name column is VARCHAR(10))
        ));
    }

    @Bean
    public JdbcBatchItemWriter<Person> itemWriter1(DataSource dataSource1) {
        return new JdbcBatchItemWriterBuilder<Person>()
                .dataSource(dataSource1)
                .sql("INSERT INTO PEOPLE (id, name) VALUES (:id, :name)")
                .beanMapped()
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Person> itemWriter2(DataSource dataSource2) {
        return new JdbcBatchItemWriterBuilder<Person>()
                .dataSource(dataSource2)
                .sql("INSERT INTO PEOPLE (id, name) VALUES (:id, :name)")
                .beanMapped()
                .build();
    }

    @Bean
    /*
     * NB: the built-in CompositeItemWriter implements ItemStreamWriter, hence it is not usable
     * with two JdbcBatchItemWriter delegates since JdbcBatchItemWriter is not an ItemStream..
     */
    public ItemWriter<Person> itemWriter(JdbcBatchItemWriter<Person> itemWriter1, JdbcBatchItemWriter<Person> itemWriter2) {
        return items -> {
            itemWriter1.write(items);
            itemWriter2.write(items);
        };
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     JtaTransactionManager jtaTransactionManager,
                     JdbcBatchItemWriter<Person> itemWriter1, JdbcBatchItemWriter<Person> itemWriter2) {
        return new StepBuilder("step")
                .repository(jobRepository)
                .transactionManager(jtaTransactionManager)
                .<Person, Person>chunk(2)
                .reader(itemReader())
                .writer(itemWriter(itemWriter1, itemWriter2))
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("job")
                .repository(jobRepository)
                .start(step)
                .build();
    }

}