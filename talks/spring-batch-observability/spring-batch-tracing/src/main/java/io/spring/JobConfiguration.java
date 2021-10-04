package io.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    @Bean
    public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
        return jobs.get("job")
                .start(steps.get("step1")
                        .tasklet((contribution, chunkContext) -> {
                            System.out.println("hello ");
                            return RepeatStatus.FINISHED;
                        })
                        .build())
                .next(steps.get("step2")
                        .tasklet((contribution, chunkContext) -> {
                            System.out.println("world");
                            return RepeatStatus.FINISHED;
                        })
                        .build())
                .build();
    }

}