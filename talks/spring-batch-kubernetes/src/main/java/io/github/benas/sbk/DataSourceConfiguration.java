package io.github.benas.sbk;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

	@Bean
	public DataSource dataSource(@Value("#{environment.DB_URL}") String url,
								 @Value("#{environment.DB_USER}") String username,
								 @Value("#{environment.DB_PASSWORD}") String password) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

}
