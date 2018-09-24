package com.codeandtech.appcoreengine.data.dsrouting;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@EnableAutoConfiguration

public class DataSourceRouterConfig{

    @Autowired
    private Environment environment;

    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.framework.datasource.postgres")

    public DataSource appcoreengineDataSource(){
        
        String url = environment.getProperty("spring.framework.dataource.url");
        String username = environment.getProperty("spring.framework.dataource.username");
        String password = environment.getProperty("spring.framework.dataource.password");
        String driverClassName = environment.getProperty("spring.framework.dataource.driverClassName");

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName).url(url).username(username).password(password);
        return dataSourceBuilder.build();

    }

}