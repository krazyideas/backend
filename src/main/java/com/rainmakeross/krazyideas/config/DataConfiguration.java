package com.rainmakeross.krazyideas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class DataConfiguration {

    @Configuration
    @Profile("default")
    static class LocalConfiguration {
        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl("jdbc:postgresql://postgres:5432/krazy");
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUsername("krazy");
            dataSource.setPassword("ideas");
            return dataSource;
        }
    }

}
