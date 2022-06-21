package com.example.demo;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
public class InfrastructureConfiguration {

    /*
     * XA data sources and transaction managers
     */
    @Bean
    public DataSource dataSource1() {
        MysqlXADataSource datasource = new MysqlXADataSource();
        datasource.setURL("jdbc:mysql://localhost:3306/test");
        datasource.setUser("root");
        datasource.setPassword("root");

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(datasource);
        xaDataSource.setUniqueResourceName("ds1");
        return xaDataSource;
    }

    @Bean
    public DataSource dataSource2() {
        MysqlXADataSource datasource = new MysqlXADataSource();
        datasource.setURL("jdbc:mysql://localhost:3307/test");
        datasource.setUser("root");
        datasource.setPassword("root");

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(datasource);
        xaDataSource.setUniqueResourceName("ds2");
        return xaDataSource;
    }

    @Bean
    public UserTransaction userTransaction() throws Exception {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(60);
        return userTransactionImp;
    }

    @Bean
    public TransactionManager transactionManager() throws Exception {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setTransactionTimeout(60);
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }

    @Bean
    public JtaTransactionManager jtaTransactionManager() throws Exception {
        return new JtaTransactionManager(userTransaction(), transactionManager());
    }

    /*
     * Spring Batch infrastructure beans. DELIBERATELY not using @EnableBatchProcessing to understand
     * which data source and transaction manager are being used.
     */
    @Bean // recommended replacement of the Map-based JobRepository implementation
    public JobRepository jobRepository() throws Exception {
        DataSource dataSource = new EmbeddedDatabaseBuilder() // no need for this to be a bean
                .setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .build();
        JdbcTransactionManager transactionManager = new JdbcTransactionManager(dataSource);

        JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTransactionManager(transactionManager);
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

}
