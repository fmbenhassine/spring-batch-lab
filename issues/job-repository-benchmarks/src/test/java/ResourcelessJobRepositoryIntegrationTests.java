import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.support.ScopeConfiguration;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.ResourcelessJobRepository;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.PlatformTransactionManager;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringJUnitConfig(classes = {JobConfiguration.class, ResourcelessJobRepositoryIntegrationTests.ResourcelessInfrastructureConfiguration.class})
public class ResourcelessJobRepositoryIntegrationTests {

    @BeforeEach
    public void deleteFile() throws Exception {
        Files.deleteIfExists(Paths.get("persons.txt"));
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
    static public class ResourcelessInfrastructureConfiguration {

        @Bean
        public JobRepository jobRepository() {
            return new ResourcelessJobRepository();
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new ResourcelessTransactionManager();
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
