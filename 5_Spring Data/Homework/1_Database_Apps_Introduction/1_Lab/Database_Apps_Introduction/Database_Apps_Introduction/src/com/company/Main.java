package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String user = "root";
        String password = "";

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement statement =
                connection.prepareStatement(
                        "SELECT first_name, " +
                        "last_name, " +
                        "u.user_name," +
                        "COUNT(ug.game_id) AS 'time' " +
                        "FROM users AS u " +
                        "JOIN users_games AS ug " +
                        "ON u.id = ug.user_id " +
                        "WHERE u.user_name = ?");

        String name = reader.readLine();
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();

        while(result.next()){
            String username = result.getString("user_name");

            if (username == null) {
                System.out.println("No such user exists");
                break;
            }

            String out = String.format("User: %s\n%s %s has played %d games",
                    username,
                    result.getString("first_name"),
                    result.getString("last_name"),
                    result.getInt("time"));
            System.out.println(out);
        }

        connection.close();
    }
}