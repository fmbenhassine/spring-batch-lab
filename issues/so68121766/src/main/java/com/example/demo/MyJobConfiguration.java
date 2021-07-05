package com.example.demo;

import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class MyJobConfiguration {

    @Bean
    public FlatFileItemReader<DAOUser> reader() {
        BeanWrapperFieldSetMapper<DAOUser> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(DAOUser.class);
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new Converter<String, Date>() {
            @Override
            public Date convert(String s) {
                return Date.valueOf(s);
            }
        });
        fieldSetMapper.setConversionService(conversionService);

        FlatFileItemReader<DAOUser> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("users.csv"));
        reader.setLineMapper(new DefaultLineMapper<DAOUser>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "dateIntegration","email","fullname","matricule","password","username" });
            }});
            setFieldSetMapper(fieldSetMapper);
        }});
        return reader;
    }

    @Bean
    public JdbcBatchItemWriter<DAOUser> writer() {
        JdbcBatchItemWriter<DAOUser> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO user ( date_integration,email,fullname,matricule,password,username) VALUES ( :dateIntegration,:email,:fullname,:matricule,:password,:username)");
        writer.setDataSource(dataSource());
        return writer;
    }

    @Bean
    public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
        return jobs.get("job")
                .start(steps.get("step")
                        .<DAOUser, DAOUser>chunk(5)
                        .reader(reader())
                        .writer(writer())
                        .build())
                .build();
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .build();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(embeddedDatabase);
        jdbcTemplate.execute("create table user (email varchar(50), fullname varchar(50), matricule varchar(50), password varchar(50), username varchar(50), date_integration date);");
        return embeddedDatabase;
    }



}