package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, StepScopeTestExecutionListener.class})
@ContextConfiguration(classes = TestExampleWithStepScopeTestExecutionListener.MyConfiguration.class)
public class TestExampleWithStepScopeTestExecutionListener {

	@Autowired
	private FlatFileItemReader<String> reader;

	public StepExecution getStepExecution() {
		StepExecution execution = MetaDataInstanceFactory.createStepExecution();
		execution.getExecutionContext().putString("fileName", "data/input.txt");
		return execution;
	}

	@Test
	public void givenMockedStep_whenReaderCalled_thenSuccess() throws Exception {
		reader.open(new ExecutionContext());
		String item = reader.read();
		Assert.assertEquals("foo", item);
		item = reader.read();
		Assert.assertEquals("bar", item);
		item = reader.read();
		Assert.assertNull(item);
		reader.close();
	}

	@Configuration
	@EnableBatchProcessing
	static class MyConfiguration {

		@Bean
		@StepScope
		public FlatFileItemReader<String> myFlatFileItemReader(@Value("#{stepExecutionContext['fileName']}") String filename) {
			return new FlatFileItemReaderBuilder<String>()
					.name("myFlatFileItemReader")
					.resource(new ClassPathResource(filename))
					.lineMapper(new PassThroughLineMapper())
					.build();
		}
	}

}
