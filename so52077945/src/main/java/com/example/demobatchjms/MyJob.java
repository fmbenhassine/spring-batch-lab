package com.example.demobatchjms;

import java.util.List;
import javax.jms.ConnectionFactory;
import javax.jms.Session;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.ChunkListenerSupport;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.jms.JmsItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setDefaultDestinationName("test-queue");
		jmsTemplate.setReceiveTimeout(10 * 1000);
		jmsTemplate.setSessionTransacted(true); // if false, messages are not put back in the queue if an error occurs during processing or writing
		jmsTemplate.setSessionAcknowledgeMode(Session.SESSION_TRANSACTED);
		return jmsTemplate;
	}

	@Bean
	public ItemReader<String> myJmsItemReader() throws Exception {
		class ItemReaderDecorator<T> implements ItemReader<T> {

			private JmsItemReader<T> delegate;

			public ItemReaderDecorator(JmsItemReader<T> delegate) {
				this.delegate = delegate;
			}

			@Override
			public T read() {
				System.out.print("Reading item from queue: ");
				T item = delegate.read();
				System.out.print(item);
				System.out.println();
				return item;
			}
		}

		JmsItemReader<String> myJmsItemReader= new JmsItemReader<>();
		myJmsItemReader.setItemType(String.class);
		myJmsItemReader.setJmsTemplate(jmsTemplate(null));
		myJmsItemReader.afterPropertiesSet();
		return new ItemReaderDecorator<>(myJmsItemReader);
	}

	@Bean(name = "receiveProcessAndWrite")
	public TaskletStep receiveProcessAndWrite() throws Exception {
		return this.stepBuilderFactory.get("receiveProcessAndWrite")
				.<String, String>chunk(2)
				.readerIsTransactionalQueue()
				.reader(myJmsItemReader())
				.processor(new ItemProcessor<String, String>() {
					@Override
					public String process(String item) throws Exception {
						System.out.println("processing item = " + item);
						return item;
					}
				})
				.writer(new ItemWriter<String>() {
					@Override
					public void write(List<? extends String> items) throws Exception {
//						throw new Exception("boom!"); // in this case, messages are put back in the queue as expected
						System.out.println("writing items = " + items);
					}
				})
				.listener(new ChunkListenerSupport() {
					@Override
					public void afterChunk(ChunkContext context) {
						System.out.println("MyJob.afterChunk");
					}

					@Override
					public void beforeChunk(ChunkContext context) {
						System.out.println("MyJob.beforeChunk");
					}
				})
				.build();

	}

	@Bean
	public Job job() throws Exception {
		return jobBuilderFactory.get("job")
				.start(receiveProcessAndWrite())
				.build();
	}

}
