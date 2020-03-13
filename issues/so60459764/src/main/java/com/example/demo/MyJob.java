package com.example.demo;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Bean
	public JdbcPagingItemReader<Person> itemReader() {
		return new JdbcPagingItemReaderBuilder<Person>()
				.saveState(false)
				.dataSource(dataSource())
				.selectClause("select id, name")
				.fromClause("from person")
				.fetchSize(5)
				.pageSize(5)
				.sortKeys(new HashMap<String, Order>() {{ put("id", Order.DESCENDING); }})
				.rowMapper((resultSet, i) -> new Person(resultSet.getInt("id"), resultSet.getString("name")))
				.build();
	}

	@Bean
	public ItemWriter<Person> itemWriter() {
		return items -> {
			for (Person person : items) {
				System.out.println(Thread.currentThread().getName() + ": " +person);
			}
		};
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.<Person, Person>chunk(2)
						.reader(itemReader())
						.writer(itemWriter())
						.taskExecutor(taskExecutor())
						.build())
				.build();
	}
	
	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(4);
		taskExecutor.setMaxPoolSize(4);
		return taskExecutor;
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/org/springframework/batch/core/schema-drop-h2.sql")
				.addScript("/org/springframework/batch/core/schema-h2.sql")
				.addScript("/schema.sql")
				.addScript("/data.sql")
				.build();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		jobLauncher.run(job, new JobParameters());

		ThreadPoolTaskExecutor taskExecutor = context.getBean(ThreadPoolTaskExecutor.class);
		taskExecutor.shutdown();
	}

}
