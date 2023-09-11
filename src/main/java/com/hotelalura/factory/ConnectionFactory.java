package com.hotelalura.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private final DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_challenge?useTimeZone=true&serverTimeZone=UTC");
        pooledDataSource.setUser("root");
        pooledDataSource.setPassword("SQLdatabase1010");
        pooledDataSource.setMaxPoolSize(10);

        this.dataSource = pooledDataSource;
    }

    public Connection getConnection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
