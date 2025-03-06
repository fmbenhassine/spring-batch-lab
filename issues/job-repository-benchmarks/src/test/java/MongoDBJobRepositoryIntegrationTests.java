import org.bson.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.support.ScopeConfiguration;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.MongoJobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MongoJobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Testcontainers(disabledWithoutDocker = true)
@SpringJUnitConfig(classes = {JobConfiguration.class, MongoDBJobRepositoryIntegrationTests.MongoDBInfrastructureConfiguration.class})
public class MongoDBJobRepositoryIntegrationTests {

	private static final DockerImageName MONGODB_IMAGE = DockerImageName.parse("mongo:8.0.1");

	@Container
	public static MongoDBContainer mongodb = new MongoDBContainer(MONGODB_IMAGE);

	@DynamicPropertySource
	static void setMongoDbConnectionString(DynamicPropertyRegistry registry) {
		registry.add("mongo.connectionString", mongodb::getConnectionString);
	}

	@Autowired
	private MongoTemplate mongoTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		Files.deleteIfExists(Paths.get("persons.txt"));
		// collections
		mongoTemplate.createCollection("BATCH_JOB_INSTANCE");
		mongoTemplate.createCollection("BATCH_JOB_EXECUTION");
		mongoTemplate.createCollection("BATCH_STEP_EXECUTION");
		// sequences
		mongoTemplate.createCollection("BATCH_SEQUENCES");
		mongoTemplate.getCollection("BATCH_SEQUENCES")
				.insertOne(new Document(Map.of("_id", "BATCH_JOB_INSTANCE_SEQ", "count", 0L)));
		mongoTemplate.getCollection("BATCH_SEQUENCES")
				.insertOne(new Document(Map.of("_id", "BATCH_JOB_EXECUTION_SEQ", "count", 0L)));
		mongoTemplate.getCollection("BATCH_SEQUENCES")
				.insertOne(new Document(Map.of("_id", "BATCH_STEP_EXECUTION_SEQ", "count", 0L)));
		// indices
		mongoTemplate.indexOps("BATCH_JOB_INSTANCE")
				.ensureIndex(new Index().on("jobName", Sort.Direction.ASC).named("job_name_idx"));
		mongoTemplate.indexOps("BATCH_JOB_INSTANCE")
				.ensureIndex(new Index().on("jobName", Sort.Direction.ASC)
						.on("jobKey", Sort.Direction.ASC)
						.named("job_name_key_idx"));
		mongoTemplate.indexOps("BATCH_JOB_INSTANCE")
				.ensureIndex(new Index().on("jobInstanceId", Sort.Direction.DESC).named("job_instance_idx"));
		mongoTemplate.indexOps("BATCH_JOB_EXECUTION")
				.ensureIndex(new Index().on("jobInstanceId", Sort.Direction.ASC).named("job_instance_idx"));
		mongoTemplate.indexOps("BATCH_JOB_EXECUTION")
				.ensureIndex(new Index().on("jobInstanceId", Sort.Direction.ASC)
						.on("status", Sort.Direction.ASC)
						.named("job_instance_status_idx"));
		mongoTemplate.indexOps("BATCH_STEP_EXECUTION")
				.ensureIndex(new Index().on("stepExecutionId", Sort.Direction.ASC).named("step_execution_idx"));
	}

	@Test
	void testJobExecution(@Autowired JobLauncher jobLauncher, @Autowired Job job) throws Exception {
		// given
		JobParameters jobParameters = new JobParametersBuilder().toJobParameters();

		// when
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);

		// then
		Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

	@Configuration
	@Import(ScopeConfiguration.class)
	static class MongoDBInfrastructureConfiguration {

		@Bean
		public JobRepository jobRepository(MongoTemplate mongoTemplate, MongoTransactionManager transactionManager)
				throws Exception {
			MongoJobRepositoryFactoryBean jobRepositoryFactoryBean = new MongoJobRepositoryFactoryBean();
			jobRepositoryFactoryBean.setMongoOperations(mongoTemplate);
			jobRepositoryFactoryBean.setTransactionManager(transactionManager);
			jobRepositoryFactoryBean.afterPropertiesSet();
			return jobRepositoryFactoryBean.getObject();
		}

		@Bean
		public JobExplorer jobExplorer(MongoTemplate mongoTemplate, MongoTransactionManager transactionManager)
				throws Exception {
			MongoJobExplorerFactoryBean jobExplorerFactoryBean = new MongoJobExplorerFactoryBean();
			jobExplorerFactoryBean.setMongoOperations(mongoTemplate);
			jobExplorerFactoryBean.setTransactionManager(transactionManager);
			jobExplorerFactoryBean.afterPropertiesSet();
			return jobExplorerFactoryBean.getObject();
		}

		@Bean
		public MongoDatabaseFactory mongoDatabaseFactory(@Value("${mongo.connectionString}") String connectionString) {
			return new SimpleMongoClientDatabaseFactory(connectionString + "/test");
		}

		@Bean
		public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory) {
			MongoTemplate template = new MongoTemplate(mongoDatabaseFactory);
			MappingMongoConverter converter = (MappingMongoConverter) template.getConverter();
			converter.setMapKeyDotReplacement(".");
			return template;
		}

		@Bean
		public MongoTransactionManager transactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
			MongoTransactionManager mongoTransactionManager = new MongoTransactionManager();
			mongoTransactionManager.setDatabaseFactory(mongoDatabaseFactory);
			mongoTransactionManager.afterPropertiesSet();
			return mongoTransactionManager;
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
