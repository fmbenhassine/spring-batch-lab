package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableBatchProcessing
public class SO73476578 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job myJob() {
        return jobBuilderFactory.get("myJob")
                .incrementer(new RunIdIncrementer())
                .flow(myStep())
                .end()
                .build();
    }

    @Bean
    public Step myStep() {
        return stepBuilderFactory.get("myStep").<String, String>chunk(2)
                .reader(myReader())
                .writer(items -> items.forEach(System.out::println))
                .listener(myPromotionListener())
                .build();
    }

    @Bean
    public ExecutionContextPromotionListener myPromotionListener() {
        ExecutionContextPromotionListener listener = new ExecutionContextPromotionListener();
        listener.setKeys(new String[] {"myKey"});
        return listener;
    }

    @Bean
    // @StepScope not needed
    ItemReader<String> myReader() {
        ArrayList<String> items = new ArrayList<>();
        items.add("foo");
        items.add("bar");
        return new MyReader(items);
    }


    public static class MyReader extends ListItemReader<String> {

        private StepExecution stepExecution;

        public MyReader(List<String> list) {
            super(list);
        }

        @Override
        public String read() {
            // some logic
            String item = super.read();
            sendForNextSteps(item);
            return item;
        }

        private void sendForNextSteps(String myDto){
            System.out.println("MyReader.sendForNextSteps: " + myDto);
            ExecutionContext stepContext = this.stepExecution.getExecutionContext();
            stepContext.put("mykey", myDto);
        }

        @BeforeStep
        public void saveStepExecution(StepExecution stepExecution) {
            this.stepExecution = stepExecution;
        }
    }
}