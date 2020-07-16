package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.sql.DataSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.Jackson2ExecutionContextStringSerializer;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class StepExecutionCountBenchmarkApp {

	public static void main(String[] args) throws IOException {
		generateH2SqlPopulationScript();
		ConfigurableApplicationContext applicationContext = SpringApplication.run(StepExecutionCountBenchmarkApp.class, args);
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("key", "75025532-4cb3-43c0-9121-c14d86d8d1aa")
				.toJobParameters();
		JobRepository jobRepository = applicationContext.getBean(JobRepository.class);
		JobInstance jobInstance =jobRepository.getLastJobExecution("job", jobParameters).getJobInstance();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		int stepExecutionCount = jobRepository.getStepExecutionCount(jobInstance, "step7");
		stopWatch.stop();

		System.out.println("stepExecutionCount = " + stepExecutionCount + " in " + stopWatch.getTotalTimeSeconds() + "s");
	}
	
	@Bean
	public JobRepository jobRepository() throws Exception {
		JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setTransactionManager(new DataSourceTransactionManager(dataSource()));
		Jackson2ExecutionContextStringSerializer serializer = new Jackson2ExecutionContextStringSerializer();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.activateDefaultTyping(new LaissezFaireSubTypeValidator());
		serializer.setObjectMapper(objectMapper);
		factoryBean.setSerializer(serializer);
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/org/springframework/batch/core/schema-drop-h2.sql")
				.addScript("/org/springframework/batch/core/schema-h2.sql")
//				.addScript("/populate-h2.sql") // classpath resource, too late to add here after being generated
				.build();
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		Path path = Paths.get("src", "main", "resources","populate-h2.sql");
		databasePopulator.setScripts(new FileSystemResource(path.toAbsolutePath().toFile()));
		databasePopulator.execute(embeddedDatabase);
		return embeddedDatabase;
	}

	private static final int TOTAL_JOB_EXECUTIONS = 10_000; // probably not realistic, but large enough to showcase the improvement
	private static final int TOTAL_STEP_EXECUTIONS_PER_JOB_EXECUTION = 100; // 1.000.000 SE in total

	private static void generateH2SqlPopulationScript() throws IOException {
		Path path = Paths.get("src", "main", "resources","populate-h2.sql");
		Files.deleteIfExists(path);
		Files.createFile(path);

		// generate a job instance (one is enough here)
		System.out.println("Generating job instances..");
		String insertJobInstance = "INSERT INTO \"PUBLIC\".\"BATCH_JOB_INSTANCE\" VALUES (1, 0, 'job', 'a77bbdb482e62bb5642fabc39f7c92e8');" + System.lineSeparator();
		Files.write(path, insertJobInstance.getBytes(), StandardOpenOption.APPEND);

		// generate job executions
		System.out.println("Generating job executions..");
		for (int i = 1; i <= TOTAL_JOB_EXECUTIONS; i++) {
			String insertJobExecution = String.format("INSERT INTO \"PUBLIC\".\"BATCH_JOB_EXECUTION\" VALUES (%s, 2, 1, TIMESTAMP '2020-07-15 15:41:53.037', TIMESTAMP '2020-07-15 15:41:53.038', TIMESTAMP '2020-07-15 15:41:53.277', 'FAILED', 'FAILED', 'error', TIMESTAMP '2020-07-15 15:41:53.277', NULL);"  + System.lineSeparator(), i);
			Files.write(path, insertJobExecution.getBytes(), StandardOpenOption.APPEND);
		}

		// generate job executions params
		System.out.println("Generating job execution parameters..");
		for (int i = 1; i <= TOTAL_JOB_EXECUTIONS ; i++) {
			String insertJobExecution = String.format("INSERT INTO \"PUBLIC\".\"BATCH_JOB_EXECUTION_PARAMS\" VALUES (%s, 'STRING', 'key', '75025532-4cb3-43c0-9121-c14d86d8d1aa', TIMESTAMP '1970-01-01 01:00:00', 0, 0.0, 'Y');" + System.lineSeparator(), i);
			Files.write(path, insertJobExecution.getBytes(), StandardOpenOption.APPEND);
		}

		// generate job executions contexts
		System.out.println("Generating job execution contexts..");
		for (int i = 1; i <= TOTAL_JOB_EXECUTIONS ; i++) {
			String insertJobExecution = String.format("INSERT INTO \"PUBLIC\".\"BATCH_JOB_EXECUTION_CONTEXT\" VALUES (%s, '{}', NULL);" + System.lineSeparator(), i);
			Files.write(path, insertJobExecution.getBytes(), StandardOpenOption.APPEND);
		}

		// For each job execution, generate 100 step executions
		System.out.println("Generating step executions..");
		int stepExecutionId = 1;
		for (int i = 1; i <= TOTAL_JOB_EXECUTIONS ; i++) {
			for (int j = 1; j <= TOTAL_STEP_EXECUTIONS_PER_JOB_EXECUTION ; j++) {
				String insertJobExecution = String.format("INSERT INTO \"PUBLIC\".\"BATCH_STEP_EXECUTION\" VALUES (%s, 3, 'step%s', %s, TIMESTAMP '2020-07-15 15:41:48.819', TIMESTAMP '2020-07-15 15:41:48.836', 'COMPLETED', 1, 0, 0, 0, 0, 0, 0, 0, 'COMPLETED', '', TIMESTAMP '2020-07-15 15:41:48.836');" + System.lineSeparator(), stepExecutionId, j, i);
				Files.write(path, insertJobExecution.getBytes(), StandardOpenOption.APPEND);
				stepExecutionId++;
			}
		}

		// generate step executions contexts
		System.out.println("Generating step execution contexts..");
		for (int i = 1; i <= TOTAL_JOB_EXECUTIONS * TOTAL_STEP_EXECUTIONS_PER_JOB_EXECUTION ; i++) {
			String insertJobExecution = String.format("INSERT INTO \"PUBLIC\".\"BATCH_STEP_EXECUTION_CONTEXT\" VALUES (%s, '{\"batch.taskletType\":\"com.example.demo.JobConfiguration$$Lambda$342/0x0000000800d1a040\",\"batch.stepType\":\"org.springframework.batch.core.step.tasklet.TaskletStep\"}', NULL);" + System.lineSeparator(), i);
			Files.write(path, insertJobExecution.getBytes(), StandardOpenOption.APPEND);
		}
	}
}
