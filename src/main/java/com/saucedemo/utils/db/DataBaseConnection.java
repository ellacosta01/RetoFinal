package com.saucedemo.utils.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private final String connectionUrl;

    public DataBaseConnection(String server, String port, String databaseName, String user, String password) {
        connectionUrl = "jdbc:mysql://" + server + ":" + port + "/" + databaseName + "?user=" + user +
                "&password=" + password;
    }

    public Connection getMySQLConnection() {
        Logger logger = LogManager.getLogger(DataBaseConnection.class);
        try {
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage());
            return null;
        }
    }
}
