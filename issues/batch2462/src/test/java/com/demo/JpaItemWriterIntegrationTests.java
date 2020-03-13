package com.demo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaItemWriterIntegrationTests.JpaConfiguration.class)
@Transactional
@DirtiesContext
public class JpaItemWriterIntegrationTests {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Before
	public void init() {
		this.jdbcTemplate.update("create table person (id int not null primary key, name varchar(32))");
	}

	@After
	public void destroy() {
		JdbcTestUtils.dropTables(this.jdbcTemplate, "person");
	}

	@Test
	public void testMerge() throws Exception {
		// given
		JpaItemWriter<Person> writer = new JpaItemWriter<>();
		writer.setEntityManagerFactory(this.entityManagerFactory);
		writer.afterPropertiesSet();
		List<Person> items = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			items.add(new Person(i, "foo" + i));
		}

		// when
		writer.write(items);

		// then
		assertEquals(1000000, JdbcTestUtils.countRowsInTable(this.jdbcTemplate, "person"));
	}

	@Test
	public void testPersist() throws Exception {
		// given
		JpaItemWriter<Person> writer = new JpaItemWriter<>();
		writer.setEntityManagerFactory(this.entityManagerFactory);
		writer.setUsePersist(true);
		writer.afterPropertiesSet();
		List<Person> items = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			items.add(new Person(i, "foo" + i));
		}

		// when
		writer.write(items);

		// then
		assertEquals(1000000, JdbcTestUtils.countRowsInTable(this.jdbcTemplate, "person"));
	}

	@Configuration
	public static class JpaConfiguration {

		@Bean
		public DataSource dataSource() {
			return new EmbeddedDatabaseBuilder()
					.setType(EmbeddedDatabaseType.H2)
					.build();
		}

		@Bean
		public JdbcTemplate jdbcTemplate(DataSource dataSource) {
			return new JdbcTemplate(dataSource);
		}

		@Bean
		public PersistenceUnitManager persistenceUnitManager() {
			DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();
			persistenceUnitManager.setDefaultDataSource(dataSource());
			persistenceUnitManager.setPackagesToScan("com.demo");
			persistenceUnitManager.afterPropertiesSet();
			return persistenceUnitManager;
		}

		@Bean
		public EntityManagerFactory entityManagerFactory() {
			LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
			factoryBean.setDataSource(dataSource());
			factoryBean.setPersistenceUnitManager(persistenceUnitManager());
			factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
			factoryBean.afterPropertiesSet();
			return factoryBean.getObject();
		}

		@Bean
		public PlatformTransactionManager transactionManager() {
			return new JpaTransactionManager(entityManagerFactory());
		}
	}



}
