package io.spring;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration(proxyBeanMethods = false)
public class MyJobConfiguration {

    @Bean
    @StepScope
    public FlatFileItemReader<Person> itemReader(@Value("#{jobParameters['fileName']}") String fileName) {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new FileSystemResource(fileName))
                .delimited()
                .names("id", "name")
                .targetType(Person.class)
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Person> itemWriter(DataSource dataSource) {
        String sql = "insert into person (id, name) values (:id, :name)";
        return new JdbcBatchItemWriterBuilder<Person>()
                .dataSource(dataSource)
                .sql(sql)
                .beanMapped()
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, PlatformTransactionManager transactionManager,
                   FlatFileItemReader<Person> itemReader, JdbcBatchItemWriter<Person> itemWriter) {
        Step myStep = new StepBuilder("myStep", jobRepository)
                .<Person, Person>chunk(100, transactionManager)
                .reader(itemReader)
                .writer(itemWriter)
                .build();

        return new JobBuilder("myJob", jobRepository)
                .start(myStep)
                .build();
    }


}