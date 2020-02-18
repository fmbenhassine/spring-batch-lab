package com.example.demo;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.batch.test.StepScopeTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestExampleWithStepScopeTestUtils.MyConfiguration.class)
public class TestExampleWithStepScopeTestUtils {

	@Autowired
	private FlatFileItemReader<String> reader;

	@Test
	public void givenMockedStep_whenReaderCalled_thenSuccess() throws Exception {
		// given
		final ExecutionContext ctx = new ExecutionContext();
		ctx.put("fileName", "data/input.txt");
		StepExecution stepExecution = MetaDataInstanceFactory.createStepExecution(ctx);

		// when
		List<String> items = StepScopeTestUtils.doInStepScope(stepExecution, () -> {
			List<String> result = new ArrayList<>();
			String item;
			reader.open(new ExecutionContext());
			while ((item = reader.read()) != null) {
				result.add(item);
			}
			reader.close();
			return result;
		});
		
		// then
		Assert.assertEquals(2, items.size());
		Assert.assertEquals("foo", items.get(0));
		Assert.assertEquals("bar", items.get(1));
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
