package com.orgmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Виктор on 19.07.2017.
 */
@Configuration
public class HerokuConfig {

    @Bean
    @Profile("heroku")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://ec2-54-247-81-76.eu-west-1.compute.amazonaws.com:5432/dakjktarst3ehg?sslmode=require");
        dataSource.setUsername( "uddtovjaqiazfc" );
        dataSource.setPassword( "d1933b118da9ecafaa98c1e733d9231e4da5e78787dcb8f596580d21b8290676" );
        return dataSource;
    }
}
