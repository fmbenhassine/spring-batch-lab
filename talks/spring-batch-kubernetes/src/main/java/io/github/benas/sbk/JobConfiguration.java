package io.github.benas.sbk;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSourceConfiguration.class)
@EnableBatchProcessing
public class JobConfiguration {

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.tasklet((contribution, chunkContext) -> {
							System.out.println("hello world");
							return RepeatStatus.FINISHED;
						})
						.build())
				.build();
	}

}
