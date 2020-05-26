package com.example.demo;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class MyJob {

	@Bean
	@Order(1)
	@StepScope
	public MyBean bean1() {
		return new MyBean("1");
	}

	@Bean
	@Order(2)
	@StepScope
	public MyBean bean2() {
		return new MyBean("2");
	}
	
	@Bean
	public OuterBean outerBean(List<MyBean> beans) {
		return new OuterBean(beans);
	}

	@Bean
	public Tasklet tasklet(OuterBean outerBean) {
		return (contribution, chunkContext) -> {
			outerBean.sayHello();
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Job job(JobBuilderFactory jobs, StepBuilderFactory steps) {
		return jobs.get("job")
				.start(steps.get("step")
						.tasklet(tasklet(null))
						.build())
				.build();
	}

}