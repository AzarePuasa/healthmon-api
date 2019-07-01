package com.azare.healthmon;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(DBConfig.class);
	
	@Value("${db.driverclassname}")
	private String dbDriverClassName;

	@Value("${db.url}")
	private String dbUrl;

	@Value("${db.username}")
	private String dbUsername;

	@Value("${db.password}")
	private String dbPassword;

	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(dbDriverClassName);
	    dataSource.setUrl(dbUrl);
	    dataSource.setUsername( dbUsername );
	    dataSource.setPassword( dbPassword );
	    
		LOG.info("dataSource url: " + dataSource.getUrl());
	    
	    return dataSource;
	}
}
