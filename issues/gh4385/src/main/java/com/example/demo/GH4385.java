package com.example.demo;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;

@Configuration
@EnableBatchProcessing
public class GH4385 {

    @Bean
    public Job job(JobRepository jobRepository, JdbcTransactionManager jdbcTransactionManager) {
        Step step = new StepBuilder("step", jobRepository)
                .<Integer, Integer>chunk(2, jdbcTransactionManager)
                .reader(new ListItemReader<>(Arrays.asList(1, 2, 3, 4)))
                .writer(chunk -> chunk.getItems().forEach(System.out::println))
                .build();

        return new JobBuilder("job", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .build();
    }

    @Bean
    public JdbcTransactionManager transactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }

    public static void main(String[] args) throws Exception {
        Metrics.addRegistry(new SimpleMeterRegistry());
        ApplicationContext context = new AnnotationConfigApplicationContext(GH4385.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());

        List<Meter> meters = Metrics.globalRegistry.getMeters();
        for (Meter meter : meters) {
            if (meter.getId().getName().equals("spring.batch.item.read")) {
                System.out.println("meter description = " + meter.getId().getDescription());
                Iterable<Measurement> measurements = meter.measure();
                for (Measurement measurement : measurements) {
                    System.out.println("measurement: statistic = " + measurement.getStatistic() + " | value = " + measurement.getValue());
                }
            }
        }
    }

}