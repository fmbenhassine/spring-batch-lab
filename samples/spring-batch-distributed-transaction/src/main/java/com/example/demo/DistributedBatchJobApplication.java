package com.example.demo;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DistributedBatchJobApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(DistributedBatchJobConfiguration.class);
        Job job = context.getBean(Job.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        jobLauncher.run(job, new JobParameters());

        String sql = "select count(*) from PEOPLE";
        DataSource dataSource = (DataSource) context.getBean("dataSource1");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Integer persons = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("Total persons in dataSource1 = " + persons); // should be 2 since the second chunk has failed

        dataSource = (DataSource) context.getBean("dataSource2");
        jdbcTemplate = new JdbcTemplate(dataSource);
        persons = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("Total persons in dataSource2 = " + persons); // should be 2 since the second chunk has failed
    }

}
