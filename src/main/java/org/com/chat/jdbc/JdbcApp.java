package org.com.chat.jdbc;

import java.sql.*;

public class JdbcApp {
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnectionFactory.createConnection();

        PreparedStatement insertUsers = connection.prepareStatement(
                "insert into users (login, first_name, last_name) values (?, ?, ?)");
        insertUsers.setString(1, "mihole");
        insertUsers.setString(2, "Михаил");
        insertUsers.setString(3, "Олегов");
        int row = insertUsers.executeUpdate();

        System.out.println("Изменили " + row + " строк(у)");




        Statement selectUsers = connection.createStatement();
        ResultSet result = selectUsers.executeQuery("" +
                "select * from users");

        while (result.next()) {
            int id = result.getInt(1);
            String login = result.getString(2);
            String firstName = result.getString("first_name");
            String lastName = result.getString(4);

            System.out.println(id + "|" + login + "|" +  firstName + "|" +  lastName );
        }

        connection.close();
    }
}
