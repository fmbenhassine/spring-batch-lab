package com.example.demo;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class DatabaseToDatabaseJob {

	@Bean
	public JdbcCursorItemReader<Person> itemReader() {
		String sql = "select * from person_in";
		return new JdbcCursorItemReaderBuilder<Person>()
				.name("personItemReader")
				.dataSource(dataSource())
				.sql(sql)
				.rowMapper(new DataClassRowMapper<>(Person.class))
				.build();
	}

	@Bean
	public JdbcBatchItemWriter<Person> itemWriter() {
		return new JdbcBatchItemWriterBuilder<Person>()
				.dataSource(dataSource())
				.sql("insert into person_out (id, name) values (:id, :name)")
				.beanMapped()
				.build();
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Person, Person>chunk(5)
						.reader(itemReader())
						.writer(itemWriter())
						.build())
				.build();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseToDatabaseJob.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());

		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
		Integer count = jdbcTemplate.queryForObject("select count(*) from person_out", Integer.class);
		System.out.println("count = " + count);
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/org/springframework/batch/core/schema-drop-h2.sql")
				.addScript("/org/springframework/batch/core/schema-h2.sql")
				.build();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(embeddedDatabase);
		jdbcTemplate.execute("create table person_in (id int primary key, name varchar(20));");
		jdbcTemplate.execute("create table person_out (id int primary key, name varchar(20));");
		for (int i = 1; i <= 10; i++) {
			jdbcTemplate.execute(String.format("insert into person_in values (%s, 'foo%s');", i, i));
		}
		return embeddedDatabase;
	}

}