package com.azare.healthmon;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEncryptableProperties
@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class HealthMonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthMonApplication.class, args);
	}

	@Bean
	public Docket apiDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.azare.healthmon")).paths(PathSelectors.any()).build();

		return docket;
	}
	
//	@Value("${spring.datasource.driverClassName}")
//	private String databaseDriverClassName;
//	 
//	@Value("${spring.datasource.url}")
//	private String datasourceUrl;
//	 
//	@Value("${spring.datasource.username}")
//	private String databaseUsername;
//	
//	@Value("${spring.datasource.password}")
//	private String databasePassword;
//	
//    @Bean
//    public DataSource getDataSource() throws IOException {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName(databaseDriverClassName);
//        dataSourceBuilder.url(datasourceUrl);
//        dataSourceBuilder.username(databaseUsername);
//        
//        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
//        
//        dataSourceBuilder.password(basicTextEncryptor.decrypt(databasePassword ));
//        return dataSourceBuilder.build();
//    }
}
