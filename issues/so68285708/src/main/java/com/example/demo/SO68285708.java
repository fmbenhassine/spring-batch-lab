package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class SO68285708 {

    @Bean
    public ListItemReader<HashMap<String, String>> itemReader() {
        HashMap<String, String> item1 = new HashMap<>();
        item1.put("id", "1");
        item1.put("name", "foo");
        HashMap<String, String> item2 = new HashMap<>();
        item2.put("id", "2");
        item2.put("name", "bar");
        return new ListItemReader<>(Arrays.asList(item1, item2));
    }

    @Bean
    public JdbcBatchItemWriter<HashMap<String, String>> itemWriter() {
        String sql = "insert into person (id, name) values (:id, :name)";
        return new JdbcBatchItemWriterBuilder<HashMap<String, String>>()
                .dataSource(dataSource())
                .sql(sql)
                .itemSqlParameterSourceProvider(item -> {
                    MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
                    mapSqlParameterSource.addValues(item);
                    return mapSqlParameterSource;
                })
                .build();
    }

    @Bean
    public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
        return jobs.get("job")
                .start(steps.get("step")
                        .<HashMap<String, String>, HashMap<String, String>>chunk(5)
                        .reader(itemReader())
                        .writer(itemWriter())
                        .build())
                .build();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(SO68285708.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());

        DataSource dataSource = context.getBean(DataSource.class);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Integer persons = jdbcTemplate.queryForObject("select count(*) from person", Integer.class);
        System.out.println("Persons in db = " + persons);
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .build();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(embeddedDatabase);
        jdbcTemplate.execute("create table person (id int primary key, name varchar(20));");
        return embeddedDatabase;
    }

    public static class Person {
        private int id;
        private String name;

        public Person() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return "Person{id=" + id + ", name='" + name + '\'' + '}';
        }
    }

}