package com.example.demo;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.JdbcTransactionManager;

// Tried both loading the java config which imports the xml config
// As well as loading the XML config which imports the Java config

@Configuration
// @ImportResource(locations = {"/application-context.xml"})
public class GH3936 {

	@Bean
	@StepScope
    public ListItemReader<Integer> itemReader() {
        return new ListItemReader<>(Arrays.asList(1, 2, 3, 4));
    }

    @Bean
    @StepScope
    public ItemWriter<Object> itemWriter() {
        return items -> items.forEach(System.out::println);
    }

    @Bean
    public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
        TaskletStep step = new StepBuilder("step")
                .repository(jobRepository)
                .transactionManager(transactionManager)
                .chunk(2)
                .reader(itemReader())
                .writer(itemWriter())
                .build();
        return new JobBuilder("job")
                .repository(jobRepository)
                .start(step)
                .build();
    }

    public static void main(String[] args) throws Exception {
        // ApplicationContext context = new AnnotationConfigApplicationContext(GH3936.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

}