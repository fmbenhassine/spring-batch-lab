package io.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.JdbcTransactionManager;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

    @Bean
    public Step step1(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository).tasklet((contribution, chunkContext) -> {
            System.out.println("Hello ");
            return RepeatStatus.FINISHED;
        }, transactionManager).build();
    }

    @Bean
    public Step step2(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
        return new StepBuilder("step2", jobRepository).tasklet((contribution, chunkContext) -> {
            System.out.println("world!");
            return RepeatStatus.FINISHED;
        }, transactionManager).build();
    }


    @Bean
    public Job job(JobRepository jobRepository, Step step1, Step step2) {
        return new JobBuilder("myJob", jobRepository)
                .start(step1)
                .next(step2)
                .build();
    }

}