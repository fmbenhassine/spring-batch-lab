package io.spring;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.adapter.ItemWriterAdapter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJobConfig {

    @Bean
    public ItemReader<User> itemReader() {
        return new ListItemReader<>(Arrays.asList(new User("foo"), new User("bar")));
    }

    @Bean
    public ItemWriterAdapter<User> itemWriter() {
        ItemWriterAdapter<User> writer = new ItemWriterAdapter<>();
        writer.setTargetObject(new MyService());
        writer.setTargetMethod("putUser");
        return writer;
    }

    @Bean
    public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
        return jobs.get("job")
                .start(steps.get("step")
                        .<User, User>chunk(5)
                        .reader(itemReader())
                        .writer(itemWriter())
                        .build())
                .build();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJobConfig.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

}
