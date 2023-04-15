package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Task_4_Change_Town_Names_Casing {
    private static Connection connection;
    private static String country;
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        country = reader.readLine();

        connectToDatabase();

        executeFields();
    }
    private static void connectToDatabase() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }

    private static void executeFields() throws SQLException {
        checkFields();

        updateFields();

        printUpdates();
    }

    private static void printUpdates() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT name " +
                "FROM towns " +
                "WHERE country = ?");

        statement.setString(1, country);
        ResultSet result = statement.executeQuery();

        List<String> towns = new ArrayList<>();

        while (result.next()) {
            towns.add(result.getString("name"));
        }

        System.out.printf("%d town names were affected.%n", towns.size());
        System.out.println(towns);
    }

    private static void updateFields() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE towns " +
                "SET name = UPPER(name) " +
                "WHERE country = ?");

        statement.setString(1, country);

        statement.executeUpdate();
    }

    private static void checkFields() throws SQLException {
        PreparedStatement statementCheck = connection.prepareStatement(
                "SELECT name " +
                 "FROM towns " +
                 "WHERE country = ?");

        statementCheck.setString(1, country);

        ResultSet result = statementCheck.executeQuery();

        if (!result.next()) {
            System.out.println("No town names were affected.");
            System.exit(0);
        }
    }
}