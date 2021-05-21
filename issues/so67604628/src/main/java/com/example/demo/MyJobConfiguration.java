package com.example.demo;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
@SuppressWarnings("rawtypes, unchecked")
public class MyJobConfiguration {

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory, JdbcTemplate jdbcTemplate, ConfigurableApplicationContext applicationContext) {
		return stepBuilderFactory.get("calculateDistinctValuesAndRegisterWriters")
				.tasklet(new DynamicWritersConfigurationTasklet(jdbcTemplate, applicationContext))
				.build();
	}

	@Bean
	public JdbcCursorItemReader<Student> itemReader(DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Student>()
				.name("studentItemReader")
				.dataSource(dataSource)
				.sql("select * from student")
				.beanRowMapper(Student.class)
				.build();
	}

	@Bean
	@StepScope
	public ClassifierCompositeItemWriter<Student> itemWriter(ConfigurableApplicationContext applicationContext) {
		// dynamically get writers from the application context and register them as delegates in the composite
		Map<String, FlatFileItemWriter> beansOfType = applicationContext.getBeansOfType(FlatFileItemWriter.class);
		// Classify students by group
		Classifier<Student, FlatFileItemWriter<Student>> classifier = student -> beansOfType.get("group" + student.getGroupId() + "Writer");
		return new ClassifierCompositeItemWriterBuilder()
				.classifier(classifier)
				.build();
	}

	@Bean
	@JobScope
	public Step step2(StepBuilderFactory stepBuilderFactory, ConfigurableApplicationContext applicationContext, DataSource dataSource) {
		SimpleStepBuilder<Student, Student> step2 = stepBuilderFactory.get("readWriteStudents")
				.<Student, Student>chunk(2)
				.reader(itemReader(dataSource))
				.writer(itemWriter(applicationContext));

		// register writers as streams in the step so that open/update/close are called correctly
		Map<String, FlatFileItemWriter> beansOfType = applicationContext.getBeansOfType(FlatFileItemWriter.class);
		for (FlatFileItemWriter flatFileItemWriter : beansOfType.values()) {
			step2.stream(flatFileItemWriter);
		}

		return step2.build();
	}

	@Bean
	public Job job(JdbcTemplate jdbcTemplate, ConfigurableApplicationContext applicationContext, DataSource dataSource,
				   JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		return jobBuilderFactory.get("job")
				.start(step1(stepBuilderFactory, jdbcTemplate, applicationContext))
				.next(step2(stepBuilderFactory, applicationContext, dataSource))
				.build();
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/org/springframework/batch/core/schema-h2.sql")
				.addScript("data.sql")
				.build();
	}

}