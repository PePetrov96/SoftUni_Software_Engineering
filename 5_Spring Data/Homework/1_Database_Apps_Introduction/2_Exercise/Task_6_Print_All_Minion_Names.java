package com.task;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Properties;

public class Task_6_Print_All_Minion_Names {
    private static ArrayDeque<String> minions = new ArrayDeque<>();
    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        connectToDatabase();

        printTable();
    }

    private static void connectToDatabase() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
    private static void printTable() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT name FROM minions");

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            minions.addLast(result.getString("name"));
        }

        while(!minions.isEmpty()) {
            System.out.println(minions.removeFirst());
            System.out.println(minions.removeLast());
        }
    }
}