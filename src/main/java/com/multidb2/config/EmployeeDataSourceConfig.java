package com.multidb2.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "employeeEntityManagerFactory",
  transactionManagerRef = "employeeTransactionManager",
  basePackages = { "com.multidb2.employeedb.repository" }
)


public class EmployeeDataSourceConfig {
	
	@Bean(name="employeeDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.employeedb.datasource")
	public DataSource accountDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name = "employeeEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean accountEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("employeeDataSource") DataSource accountDataSource) {
		return builder
				.dataSource(accountDataSource)
				.packages("com.multidb2.employeedb.entity")
				.build();
	}

	@Bean(name = "employeeTransactionManager")
	public PlatformTransactionManager accountTransactionManager(
			@Qualifier("employeeEntityManagerFactory") EntityManagerFactory accountEntityManagerFactory) {
		return new JpaTransactionManager(accountEntityManagerFactory);
	}

}
