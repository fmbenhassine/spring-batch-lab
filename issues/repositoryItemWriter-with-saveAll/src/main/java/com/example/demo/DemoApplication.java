package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/org/springframework/batch/core/schema-drop-h2.sql")
				.addScript("/org/springframework/batch/core/schema-h2.sql")
				.build();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(embeddedDatabase);
		jdbcTemplate.execute("create table person (id int primary key, name varchar(20));");
		return embeddedDatabase;
	}

	@Bean
	public CommandLineRunner dbChecker(DataSource dataSource) {
		return new DbChecker(dataSource);
	}

	static class DbChecker implements CommandLineRunner, Ordered {

		private final JdbcTemplate jdbcTemplate;

		DbChecker(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

		@Override
		public void run(String... args) throws Exception {
			Integer persons = jdbcTemplate.queryForObject("select count(*) from person", Integer.class);
			System.out.println("Persons in db = " + persons);
		}

		@Override
		public int getOrder() {
			return 1; // make sure this runner is executed after the JobLauncherCommandLineRunner (which has a default order of 0)
		}
	}

}
