import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JobConfiguration {

    record Person(String firstName, String lastName) { }

    @Bean
    public Job job(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        FlatFileItemReader<Person> itemReader = new FlatFileItemReaderBuilder<Person>()
                .name("itemReader")
                .resource(new FileSystemResource("persons.csv"))
                .delimited()
                .names("firstName", "lastName")
                .targetType(Person.class)
                .build();

        ItemProcessor<Person, Person> itemProcessor = item -> new Person(item.firstName().toUpperCase(), item.lastName().toUpperCase());

        FlatFileItemWriter<Person> itemWriter = new FlatFileItemWriterBuilder<Person>()
                .name("itemWriter")
                .resource(new FileSystemResource("persons.txt"))
                .delimited()
                .names("firstName", "lastName")
                .build();

        Step step1 = new StepBuilder("step1", jobRepository)
                .tasklet((contribution, chunkContext) -> RepeatStatus.FINISHED, transactionManager)
                .build();

        Step step2 = new StepBuilder("step2", jobRepository)
                .<Person, Person>chunk(10, transactionManager)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return new JobBuilder("job", jobRepository)
                .start(step1)
                .next(step2)
                .build();
    }
}
