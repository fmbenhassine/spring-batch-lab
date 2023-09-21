package io.github.fmbenhassine.spring.batch;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.support.JdbcTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@PropertySource("application.properties")
public class BatchApplication {

    @Bean
    public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
        return new JobBuilder( "job", jobRepository)
                .start(new StepBuilder("step", jobRepository)
                        .tasklet((contribution, chunkContext) -> {
                            System.out.println("hello world");
                            return RepeatStatus.FINISHED;
                        }, transactionManager)
                        .build())
                .build();
    }

    @Bean
    public DataSource dataSource(Environment environment) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL(environment.getProperty("spring.datasource.url"));
        dataSource.setUser(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean
    public JdbcTransactionManager transactionManager(DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(BatchApplication.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

}