package io.spring;

import javax.sql.DataSource;

import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@ImportRuntimeHints(SpringBatchNativeApp.BatchApplicationRuntimeHints.class)
@RegisterReflectionForBinding(Person.class)
public class SpringBatchNativeApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBatchNativeApp.class, args);

		DataSource dataSource = context.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Integer persons = jdbcTemplate.queryForObject("select count(id) from person", Integer.class);
		System.out.println("Number of persons in db = " + persons);
	}

	static class BatchApplicationRuntimeHints implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			// TODO remove the following hint once
			// https://github.com/spring-projects/spring-batch/issues/4248 is resolved
			hints.proxies().registerJdkProxy(AopProxyUtils.completeJdkProxyInterfaces(JobOperator.class));
		}

	}

}
