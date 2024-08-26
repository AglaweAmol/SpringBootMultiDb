package com.multidb2.config;

import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "countryEntityManagerFactory",
  transactionManagerRef = "countryTransactionManager",
  basePackages = { "com.multidb2.repository.countrydb" }
)
public class CountryDataSourceConfig {
	@Bean(name="countryDataSource")
	@ConfigurationProperties(prefix="spring.countrydb.datasource")
	public DataSource userDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "countryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("countryDataSource") DataSource userDataSource) {
		return builder
				.dataSource(userDataSource)
				.packages("com.multidb2.entity.countrydb")
				.build();
	}
	
	@Bean(name = "countryTransactionManager")
	public PlatformTransactionManager userTransactionManager(
			@Qualifier("countryEntityManagerFactory") EntityManagerFactory userEntityManagerFactory) {
		return new JpaTransactionManager(userEntityManagerFactory);
	}
}
