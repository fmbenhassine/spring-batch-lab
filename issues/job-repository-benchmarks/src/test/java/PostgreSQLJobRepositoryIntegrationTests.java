import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.support.ScopeConfiguration;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers(disabledWithoutDocker = true)
@SpringJUnitConfig(classes = {JobConfiguration.class, PostgreSQLJobRepositoryIntegrationTests.PostgreSQLInfrastructureConfiguration.class})
class PostgreSQLJobRepositoryIntegrationTests {

	private static final DockerImageName POSTGRESQL_IMAGE = DockerImageName.parse("postgres:13.3");

	@Container
	public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(POSTGRESQL_IMAGE);

	@Autowired
	private DataSource dataSource;

	@BeforeEach
	void setUp() throws Exception {
		Files.deleteIfExists(Paths.get("persons.txt"));
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("/org/springframework/batch/core/schema-postgresql.sql"));
		databasePopulator.execute(this.dataSource);
	}

	@Test
	void testJobExecution(@Autowired JobLauncher jobLauncher, @Autowired Job job) throws Exception {
		// given
		JobParameters jobParameters = new JobParametersBuilder().toJobParameters();

		// when
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);

		// then
		assertNotNull(jobExecution);
		assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

	@Configuration
	@Import(ScopeConfiguration.class)
	static class PostgreSQLInfrastructureConfiguration {

		@Bean
		public DataSource dataSource() throws Exception {
			PGSimpleDataSource datasource = new PGSimpleDataSource();
			datasource.setURL(postgres.getJdbcUrl());
			datasource.setUser(postgres.getUsername());
			datasource.setPassword(postgres.getPassword());
			return datasource;
		}

		@Bean
		public JdbcTransactionManager transactionManager(DataSource dataSource) {
			return new JdbcTransactionManager(dataSource);
		}


		@Bean
		public JobRepository jobRepository(DataSource dataSource, JdbcTransactionManager transactionManager) throws Exception {
			JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
			factoryBean.setDataSource(dataSource);
			factoryBean.setTransactionManager(transactionManager);
			factoryBean.afterPropertiesSet();
			return factoryBean.getObject();
		}

		@Bean
		public JobLauncher jobLauncher(JobRepository jobRepository) {
			TaskExecutorJobLauncher taskExecutorJobLauncher = new TaskExecutorJobLauncher();
			taskExecutorJobLauncher.setJobRepository(jobRepository);
			taskExecutorJobLauncher.setTaskExecutor(new SyncTaskExecutor());
			return taskExecutorJobLauncher;
		}

	}

}
