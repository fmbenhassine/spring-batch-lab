package io.spring;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class MyJob {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .addScript("test-schema.sql")
                .build();
    }

    @Bean
    public Tasklet tasklet(DataSource dataSource) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        MethodInvokingTaskletAdapter tasklet = new MethodInvokingTaskletAdapter();
        tasklet.setTargetObject(jdbcTemplate);
        tasklet.setTargetMethod("update");
        tasklet.setArguments(new Object[]{"update test set v = :value", new MapSqlParameterSource("value", "bar")});
        return tasklet;
    }

    @Bean
    public Job job(JobBuilderFactory jobs, StepBuilderFactory steps, DataSource dataSource) {
        return jobs.get("job")
                .start(steps.get("step")
                        .tasklet(tasklet(dataSource))
                        .build())
                .build();
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyJob.class);
        DataSource dataSource = context.getBean(DataSource.class);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String currentValue = jdbcTemplate.queryForObject("select v from test where k = 'name'", String.class);
        System.out.println("currentValue = " + currentValue);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);
        Job job = context.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
        String updatedvalue = jdbcTemplate.queryForObject("select v from test where k = 'name'", String.class);
        System.out.println("updatedValue = " + updatedvalue);
    }


}