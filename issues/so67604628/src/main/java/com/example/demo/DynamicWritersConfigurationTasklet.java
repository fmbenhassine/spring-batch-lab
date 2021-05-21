package com.example.demo;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;

class DynamicWritersConfigurationTasklet implements Tasklet {

    private JdbcTemplate jdbcTemplate;
    private ConfigurableApplicationContext applicationContext;

    public DynamicWritersConfigurationTasklet(JdbcTemplate jdbcTemplate, ConfigurableApplicationContext applicationContext) {
        this.jdbcTemplate = jdbcTemplate;
        this.applicationContext = applicationContext;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;

        String sql = "select distinct(groupId) from student";
        List<Integer> groups = jdbcTemplate.queryForList(sql, Integer.class);
        for (Integer group : groups) {
            String name = "group" + group + "Writer";
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClassName(FlatFileItemWriter.class.getName());
            MutablePropertyValues propertyValues = new MutablePropertyValues();
            propertyValues.addPropertyValue("name", name);
            propertyValues.addPropertyValue("lineAggregator", new PassThroughLineAggregator<>());
            propertyValues.addPropertyValue("resource", new FileSystemResource(group + ".txt"));
            propertyValues.addPropertyValue("headerCallback", (FlatFileHeaderCallback) writer -> writer.write("header"));
            propertyValues.addPropertyValue("footerCallback", (FlatFileFooterCallback) writer -> writer.write("footer"));
            beanDefinition.setPropertyValues(propertyValues);
            registry.registerBeanDefinition(name, beanDefinition);
        }
        return RepeatStatus.FINISHED;
    }

}
