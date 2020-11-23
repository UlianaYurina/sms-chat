package org.com.chat.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionFactory {


    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/chat_new", //5432 port for home computer, work - 5433
                "postgres",
                "1234");
    }
}
