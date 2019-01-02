package org.droidwiki.batchdemo;

import java.util.Iterator;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class BatchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchDemoApplication.class, args);
	}

@Bean
public static BeanFactoryPostProcessor beanListingBeanFactoryPostProcessor() {
	return factory -> {
		Iterator<String> iterator = factory.getBeanNamesIterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println("bean = " + next);
		}
	};
}

}
