package com.example.demo;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.kafka.KafkaItemReader;
import org.springframework.batch.item.kafka.builder.KafkaItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.utils.KafkaTestUtils;

@Configuration
@EnableBatchProcessing
public class MyJobConfiguration {

	public static final String TOPIC_NAME = "topic1";

	private JobBuilderFactory jobs;
	private StepBuilderFactory steps;

	public MyJobConfiguration(JobBuilderFactory jobs, StepBuilderFactory steps) {
		this.jobs = jobs;
		this.steps = steps;
	}

	@Bean
	public EmbeddedKafkaBroker embeddedKafkaBroker() {
		return new EmbeddedKafkaBroker(1, false, 1, TOPIC_NAME);
	}

	@Bean
	public KafkaItemReader<Object, Map<Object,Object>> itemReader() {
		Properties consumerProperties = getConsumerProperties();
		return new KafkaItemReaderBuilder<Object, Map<Object,Object>>()
				.name("kafkaItemReader")
				.consumerProperties(consumerProperties)
				.topic(TOPIC_NAME)
				.partitions(0)
				.pollTimeout(Duration.ofSeconds(1))
				.build();
	}

	private Properties getConsumerProperties() {
		Properties consumerProperties = new Properties();
		consumerProperties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, embeddedKafkaBroker().getBrokersAsString());
		consumerProperties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "1");
		consumerProperties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		consumerProperties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MapDeserializer.class.getName());
		return consumerProperties;
	}

	@Bean
	public ItemWriter<Map<Object,Object>> itemWriter() {
		return items -> {
			for (Map<Object,Object> item : items) {
				System.out.println("item = " + item.entrySet().iterator().next());
			}
		};
	}

	@Bean
	public Step step(ItemReader<Map<Object,Object>> reader, ItemWriter<Map<Object,Object>> writer) {
		return this.steps.get("step")
				.<Map<Object,Object>, Map<Object,Object>>chunk(5)
				.reader(reader)
				.writer(writer)
				.build();
	}

	@Bean
	public Job job(EmbeddedKafkaBroker embeddedKafkaBroker) {
		return this.jobs.get("job")
				.start(step(null, null))
				.listener(new JobExecutionListener() {
					@Override
					public void beforeJob(JobExecution jobExecution) {
						Map<String, Object> producerProperties = KafkaTestUtils.producerProps(embeddedKafkaBroker);
						producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
						producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MapSerializer.class);
						ProducerFactory<Object, Map<Object,Object>> producerFactory = new DefaultKafkaProducerFactory<>(producerProperties);
						KafkaTemplate<Object, Map<Object,Object>> template = new KafkaTemplate<>(producerFactory);
						template.setDefaultTopic(TOPIC_NAME);
						Map<Object, Object> map1 = new HashMap<>();
						map1.put("foo1", "bar1");
						template.sendDefault(map1);
						Map<Object, Object> map2 = new HashMap<>();
						map2.put("foo2", "bar2");
						template.sendDefault(map2);
					}

					@Override
					public void afterJob(JobExecution jobExecution) {
						embeddedKafkaBroker.destroy();
					}
				})
				.build();
	}
	
	
	// quick and dirty serializer / deserializer for maps just for the purpose of the issue
	public static class MapDeserializer implements Deserializer<Map<Object, Object>> {

		@Override
		public Map<Object, Object> deserialize(String s, byte[] bytes) {
			String serialized = new String(bytes);
			String[] strings = serialized.split(",");
			HashMap<Object, Object> map = new HashMap<>();
			map.put(strings[0], strings[1]);
			return map;
		}
	}

	public static class MapSerializer implements Serializer<Map<Object, Object>> {

		@Override
		public byte[] serialize(String topic, Map<Object, Object> data) {
			Map.Entry<Object, Object> entry = data.entrySet().iterator().next();
			return (entry.getKey().toString() + "," + entry.getValue().toString()).getBytes();
		}
	}

}