package io.spring;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.partition.StepExecutionSplitter;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.partition.support.SimpleStepExecutionSplitter;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step managerStep() {
		return stepBuilderFactory.get("managerStep")
				.partitioner(workerStep())
				.taskExecutor(new SimpleAsyncTaskExecutor())
				.splitter(stepExecutionSplitter(null))
				.build();
	}

	@Bean
	public StepExecutionSplitter stepExecutionSplitter(JobRepository jobRepository) {
		SimpleStepExecutionSplitter stepExecutionSplitter = new SimpleStepExecutionSplitter();
		stepExecutionSplitter.setPartitioner(partitioner());
		stepExecutionSplitter.setJobRepository(jobRepository);
		stepExecutionSplitter.setStepName("workerStep");
		return stepExecutionSplitter;
	}

	@Bean
	public Partitioner partitioner() {
		return gridSize -> {
			Map<String, ExecutionContext> map = new HashMap<>(gridSize);
			for (int i = 0; i < gridSize; i++) {
				ExecutionContext executionContext = new ExecutionContext();
				executionContext.put("data", "data" + i);
				String key = "partition" + i;
				map.put(key, executionContext);
			}
			return map;
		};
	}

	@Bean
	public Step workerStep() {
		return stepBuilderFactory.get("workerStep")
				.tasklet(getTasklet(null))
				.build();
	}

	@Bean
	@StepScope
	public Tasklet getTasklet(@Value("#{stepExecutionContext['data']}") String partitionData) {
		return (contribution, chunkContext) -> {
			boolean fail = Boolean.parseBoolean((String) chunkContext.getStepContext().getJobParameters().get("fail"));
			if (fail && partitionData.equals("data2")) {
				throw new RuntimeException("Partition " + partitionData + " has failed");
			}
			System.out.println(Thread.currentThread().getName() + " processing partitionData = " + partitionData);
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job")
				.start(managerStep())
				.build();
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("/org/springframework/batch/core/schema-h2.sql")
				.build();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);

		// first run: partition2 fails
		System.out.println("##########");
		System.out.println("First run");
		System.out.println("##########");
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("name", "foo")
				.addString("fail", "true", false)
				.toJobParameters();
		jobLauncher.run(job, jobParameters);

		Thread.sleep(500);

		// second run: only partition2 is restarted
		System.out.println("##########");
		System.out.println("Second run");
		System.out.println("##########");
		jobParameters = new JobParametersBuilder()
				.addString("name", "foo")
				.addString("fail", "false", false)
				.toJobParameters();
		jobLauncher.run(job, jobParameters);
	}

}
