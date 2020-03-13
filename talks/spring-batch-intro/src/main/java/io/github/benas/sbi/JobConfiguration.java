package io.github.benas.sbi;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import static org.springframework.batch.repeat.RepeatStatus.FINISHED;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {

	private static final String FTP_DIR = "/tmp/ftp/";
	private static final String INPUT_DIR = "/tmp/in/";
	private static final String ARCHIVE_DIR = "/tmp/arc/";

	private JobBuilderFactory jobBuilderFactory;

	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	public JobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public Step copyFileStep() {
		return stepBuilderFactory.get("copyFileStep")
				.tasklet(copyFileTasklet(null))
				.build();
	}

	@Bean
	@StepScope
	public Tasklet copyFileTasklet(@Value("#{jobParameters['inputFile']}") String file) {
		return (contribution, chunkContext) -> {
			Files.copy(
					Paths.get(FTP_DIR + file),
					Paths.get(INPUT_DIR + file),
					StandardCopyOption.REPLACE_EXISTING);
			return FINISHED;
		};
	}

	@Bean
	public Step dataIngestionStep() {
		return stepBuilderFactory.get("dataIngestionStep")
				.<Person, Person>chunk(3)
				.reader(reader(null))
				.processor(processor())
				.writer(writer(null))
				.build();
	}

	@Bean
	@StepScope
	public FlatFileItemReader<Person> reader(@Value("#{jobParameters['inputFile']}") String resource) {
		return new FlatFileItemReaderBuilder<Person>()
				.name("personItemReader")
				.resource(new FileSystemResource(INPUT_DIR + resource))
				.delimited()
				.names(new String[]{"name"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
					setTargetType(Person.class);
				}})
				.build();
	}

	@Bean
	public ItemProcessor<Person, Person> processor() {
		return person -> new Person(person.getId(), person.getName().toUpperCase());
	}

	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Person>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO PERSON (name) VALUES (:name)")
				.dataSource(dataSource)
				.build();
	}

	@Bean
	public Step moveFileStep() {
		return stepBuilderFactory.get("moveFileStep")
				.tasklet(moveFileTasklet(null))
				.build();
	}

	@Bean
	@StepScope
	public Tasklet moveFileTasklet(@Value("#{jobParameters['inputFile']}") String file) {
		return (contribution, chunkContext) -> {
			Files.move(
					Paths.get(INPUT_DIR + file),
					Paths.get(ARCHIVE_DIR + file),
					StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
			return FINISHED;
		};
	}

	@Bean
	public Job dataIngestionJob() {
		return jobBuilderFactory.get("dataIngestionJob")
				.start(copyFileStep())
				.next(dataIngestionStep())
				.next(moveFileStep())
				.build();
	}

}
