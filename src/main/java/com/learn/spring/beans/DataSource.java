package com.learn.spring.beans;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.sql.*;
@Component
public class DataSource {
    private HikariDataSource hds ;


    public DataSource(@Value("${database_driver}") String database_driver,
                      @Value("${database_url}") String database_url,
                      @Value("${database_login}") String database_login,
                      @Value("${database_password}") String database_password) {


        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(database_url);
        config.setUsername(database_login);
        config.setPassword(database_password);
        config.setDriverClassName(database_driver);
        hds=new HikariDataSource(config);
    }


    public Connection getConnection()  throws SQLException {
        return hds.getConnection();
    }


}

