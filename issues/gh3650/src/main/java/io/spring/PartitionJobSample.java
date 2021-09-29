package io.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
public class PartitionJobSample {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public PartitionJobSample(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public Step managerStep() {
		return steps.get("managerStep")
				.partitioner(workerStep().getName(), partitioner())
				.step(workerStep())
				.gridSize(5)
				.taskExecutor(taskExecutor())
				.build();
	}

	@Bean
	public SimpleAsyncTaskExecutor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
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
		return steps.get("workerStep")
				.tasklet(getTasklet(null))
				.build();
	}

	@Bean
	@StepScope
	public Tasklet getTasklet(@Value("#{stepExecutionContext['data']}") String partitionData) {
		return (contribution, chunkContext) -> {
			System.out.println(Thread.currentThread().getName() + " processing partitionData = " + partitionData);
			contribution.incrementWriteCount(Integer.MAX_VALUE / 4);
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(managerStep())
				.build();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(PartitionJobSample.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
		int writeCount = jobExecution.getStepExecutions().iterator().next().getWriteCount();
		System.out.println("writeCount = " + writeCount); // prints: writeCount = -1610612741 (silent integer overflow in DefaultStepExecutionAggregator)
	}

}