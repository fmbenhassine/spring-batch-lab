package com.example.demo;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MyJobConfig extends BasicBatchConfigurer {

    private final DataSource dataSource;

    protected MyJobConfig(BatchProperties properties, DataSource dataSource, TransactionManagerCustomizers transactionManagerCustomizers) {
        super(properties, dataSource, transactionManagerCustomizers);
        this.dataSource = dataSource;
    }

    @Bean
    public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
        return jobs.get("job")
                .incrementer(new RunIdIncrementer())
                .start(steps.get("step")
                        .tasklet((contribution, chunkContext) -> {
                            System.out.println("running job instance " + chunkContext.getStepContext().getJobParameters());
                            return RepeatStatus.FINISHED;
                        })
                        .build())
                .build();
    }

    @Override
    protected JobRepository createJobRepository() throws Exception {
        JobRepositoryFactoryBean repositoryFactoryBean = new JobRepositoryFactoryBean();
        repositoryFactoryBean.setIsolationLevelForCreate("ISOLATION_REPEATABLE_READ");
        repositoryFactoryBean.setDataSource(this.dataSource);
        repositoryFactoryBean.setTransactionManager(getTransactionManager());
        repositoryFactoryBean.afterPropertiesSet();
        return repositoryFactoryBean.getObject();
    }
}