/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class MyJob {

	private final JobBuilderFactory jobs;

	private final StepBuilderFactory steps;

	public MyJob(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public ItemReader<Integer> itemReader() {
		return new ListItemReader<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	}

	@Bean
	public FlatFileItemWriter<Integer> itemWriter() {
		FlatFileItemWriter<Integer> itemWriter = new FlatFileItemWriter<Integer>() {
			@Override
			public String doWrite(List<? extends Integer> items) {
				String itemsAsString = super.doWrite(items);
				return "page header" + lineSeparator +
						itemsAsString +
						"page footer" + lineSeparator;
			}
		};
		itemWriter.setName("itemWriter");
		itemWriter.setResource(new FileSystemResource("data.txt"));
		itemWriter.setLineAggregator(new PassThroughLineAggregator<>());
		itemWriter.setHeaderCallback(writer -> writer.write("header"));
		itemWriter.setFooterCallback(writer -> writer.write("footer"));
		return itemWriter;
	}

	/*
	 * Use this writer if the page size does not equal the chunk size
	 */
	/*
	private static int PAGE_SIZE = 3;
	@Bean
	public FlatFileItemWriter<Integer> itemWriter2() {
		FlatFileItemWriter<Integer> itemWriter = new FlatFileItemWriter<Integer>() {
			int itemNumber;
			@Override
			public String doWrite(List<? extends Integer> items) {
				StringBuilder lines = new StringBuilder();
				Iterator<? extends Integer> iterator = items.iterator();
				if (getOutputState().getLinesWritten() == 0) {
					lines.append("page header").append(lineSeparator);
				}
				while(iterator.hasNext()) {
					Integer item = iterator.next();
					lines.append(this.lineAggregator.aggregate(item)).append(this.lineSeparator);
					itemNumber++;
					if (itemNumber % PAGE_SIZE == 0) {
						lines.append("page footer").append(lineSeparator);
						lines.append("page header").append(lineSeparator);
					}
				}
				if (getOutputState().getLinesWritten() > 0) {
					lines.append("page footer").append(lineSeparator);
				}

				return lines.toString();
			}
		};
		itemWriter.setName("itemWriter");
		itemWriter.setResource(new FileSystemResource("data.txt"));
		itemWriter.setLineAggregator(new PassThroughLineAggregator<>());
		itemWriter.setHeaderCallback(writer -> writer.write("header"));
		itemWriter.setFooterCallback(writer -> writer.write("footer"));
		return itemWriter;
	}
	*/

	@Bean
	public Step step() {
		return steps.get("step")
				.<Integer, Integer>chunk(5)
				.reader(itemReader())
				.writer(itemWriter())
				.build();
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(step())
				.build();
	}

}
