package com.example.demo;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;

@Configuration
@EnableBatchProcessing
public class CompositeItemReaderSample {

	@Bean
	public FlatFileItemReader<Person> itemReader1() {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personItemReader")
				.resource(new FileSystemResource("persons1.csv"))
				.delimited()
				.names("id", "name")
				.targetType(Person.class)
				.build();
	}

	@Bean
	public FlatFileItemReader<Person> itemReader2() {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personItemReader")
				.resource(new FileSystemResource("persons2.csv"))
				.delimited()
				.names("id", "name")
				.targetType(Person.class)
				.build();
	}

	@Bean
	public JdbcCursorItemReader<Person> itemReader3() {
		String sql = "select * from person_source";
		return new JdbcCursorItemReaderBuilder<Person>()
				.name("personItemReader")
				.dataSource(dataSource())
				.sql(sql)
				.beanRowMapper(Person.class)
				.build();
	}

	@Bean
	public CompositeItemReader<Person> itemReader() {
		return new CompositeItemReader<>(Arrays.asList(itemReader1(), itemReader2(), itemReader3()));
	}

	@Bean
	public JdbcBatchItemWriter<Person> itemWriter() {
		String sql = "insert into person_target (id, name) values (:id, :name)";
		return new JdbcBatchItemWriterBuilder<Person>()
				.dataSource(dataSource())
				.sql(sql)
				.beanMapped()
				.build();
	}

	@Bean
	public Job job(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
		return new JobBuilder("job", jobRepository)
				.start(new StepBuilder("step", jobRepository)
						.<Person, Person>chunk(5, transactionManager)
						.reader(itemReader())
						.writer(itemWriter())
						.build())
				.build();
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/org/springframework/batch/core/schema-drop-h2.sql")
				.addScript("/org/springframework/batch/core/schema-h2.sql")
				.addScript("schema.sql")
				.addScript("data.sql")
				.build();
	}

	@Bean
	public JdbcTransactionManager transactionManager(DataSource dataSource) {
		return new JdbcTransactionManager(dataSource);
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(CompositeItemReaderSample.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());

		DataSource dataSource = context.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Integer persons = jdbcTemplate.queryForObject("select count(*) from person_target", Integer.class);
		System.out.println("Persons in db = " + persons); // should be 6
	}

}
