package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
public class SO68267922 {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public SO68267922(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(masterStep())
                .build();
    }

    @Bean
    public Step masterStep() {
        return stepBuilderFactory.get("masterStep")
                .partitioner(slaveStep().getName(), partitioner())
                .step(slaveStep())
                .gridSize(1)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Step slaveStep() {
        return stepBuilderFactory.get("slaveStep")
                .tasklet(new TaskletWait())
                .build();
    }

    @Bean
    public Partitioner partitioner() {
        return gridSize -> {
            Map<String, ExecutionContext> map = new HashMap<>(35);
            for (int i = 0; i < 35; i++) {
                ExecutionContext executionContext = new ExecutionContext();
                executionContext.put("data", "data" + i);
                String key = "partition" + i;
                map.put(key, executionContext);
            }
            return map;
        };
    }

    @Bean
    public SimpleAsyncTaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleAsyncTaskExecutor.setConcurrencyLimit(15);
        return simpleAsyncTaskExecutor;
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
        ApplicationContext context = new AnnotationConfigApplicationContext(SO68267922.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

    public static class TaskletWait implements Tasklet {
        @Override
        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext){
            String stepName = contribution.getStepExecution().getStepName();
            System.out.println(Thread.currentThread().getName() +  " starting step: " + stepName);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            contribution.setExitStatus(ExitStatus.COMPLETED);
            return RepeatStatus.FINISHED;
        }
    }

}