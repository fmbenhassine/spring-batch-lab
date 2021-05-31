import java.util.List;

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
import org.springframework.batch.extensions.excel.RowMapper;
import org.springframework.batch.extensions.excel.mapping.BeanWrapperRowMapper;
import org.springframework.batch.extensions.excel.mapping.PassThroughRowMapper;
import org.springframework.batch.extensions.excel.poi.PoiItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class MyJob {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	@StepScope
	public PoiItemReader<Player> excelReader() {
		PoiItemReader<Player> reader = new PoiItemReader<>();
		reader.setResource(new FileSystemResource("src/main/resources/player.xls"));
		reader.setRowMapper(rowMapper());
		return reader;
	}

	@Bean
	public RowMapper<Player> rowMapper() {
		BeanWrapperRowMapper<Player> playerBeanWrapperRowMapper = new BeanWrapperRowMapper<>();
		playerBeanWrapperRowMapper.setTargetType(Player.class);
		return playerBeanWrapperRowMapper;
	}

	@Bean
	public Job job() {
		return jobs.get("job")
				.start(steps.get("step")
						.<Player, Player>chunk(2)
						.reader(excelReader())
						.writer(items -> items.forEach(System.out::println))
						.build()
				)
				.build();
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("/org/springframework/batch/core/schema-hsqldb.sql")
				.build();
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
		JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		Job job = context.getBean(Job.class);
		JobParameters jobParameters = new JobParametersBuilder()
				.toJobParameters();
		jobLauncher.run(job, jobParameters);
	}

}
