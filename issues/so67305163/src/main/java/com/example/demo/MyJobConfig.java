package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Configuration
@EnableBatchProcessing
public class MyJobConfig {

    @Bean
    @StepScope
    public ItemReader<Integer> itemReader() {
        return new ListItemReader<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)) {
            @Override
            public Integer read() {
                Integer item = super.read();
                System.out.println(Thread.currentThread().getName() + " reading item " + item);
                return item;
            }
        };
    }

    @Bean
    public ItemWriter<Integer> itemWriter() {
        return items -> items.forEach((Consumer<Integer>) item -> System.out.println(Thread.currentThread().getName() + " writing item " + item));
    }

    @Bean
    public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
        return jobs.get("job")
                .start(steps.get("step")
                        .<Integer, Integer>chunk(5)
                        .reader(itemReader())
                        .writer(itemWriter())
                        .build())
                .build();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJobConfig.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);

        JobParameters jobParameters1 = new JobParametersBuilder()
                .addString("name", "foo").toJobParameters();
        JobParameters jobParameters2 = new JobParametersBuilder()
                .addString("name", "bar").toJobParameters();

        Callable<Object> jobExecution1 = Executors.callable(() -> {
            try {
                jobLauncher.run(job, jobParameters1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Callable<Object> jobExecution2 = Executors.callable(() -> {
            try {
                jobLauncher.run(job, jobParameters2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.invokeAll(Arrays.asList(jobExecution1, jobExecution2));
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        executorService.shutdown();
    }

}
