package com.football;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class ConnectionFreeDB {

    private static final String URL = "jdbc:mysql://sql7.freesqldatabase.com"; // ?autoReconnect=true&useSSL=false
    private static final String USERNAME = "sql7363392";
    private static final String PASSWORD = "dIPN6RKHCa";

    static Connection openFreeDB() {
        Connection connection = null;
//==================================================
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//==================================================
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("connection is good");
            } else {
                System.out.println("without connection");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    void closeFreeDB(Connection connection) {
        try {
            connection.close();
            if (connection.isClosed()) {
                System.out.println("connection is close");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
