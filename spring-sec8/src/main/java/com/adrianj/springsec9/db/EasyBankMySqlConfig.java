package com.adrianj.springsec9.db;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.*;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "DemoSecEntityManagerFactory",
        basePackages = "com.adrianj.springsec9.db.repositories",
        transactionManagerRef = "DemoSecTransactionManager"
)
public class EasyBankMySqlConfig {
    @Bean(name = "DemoSecDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "DemoSecDataSource")
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource dataSource(@Qualifier("DemoSecDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "DemoSecEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("DemoSecDataSource") DataSource dataSource
    ) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return builder
                .dataSource(dataSource)
                .packages("com.adrianj.springsec9.db.entities")
                .properties(properties)
                .build();
    }

    @Bean(name ="DemoSecTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("DemoSecEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}