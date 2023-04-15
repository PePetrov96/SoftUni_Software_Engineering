package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class Task_7_Increase_Minions_Age {
    private static Connection connection;
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        connectToDatabase();

        int[] minionIDs = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int id : minionIDs) {
            updateMinion(id);
        }

        printMinions();
    }
    private static void printMinions() throws SQLException {
        String sql = "SELECT name, age FROM minions";

        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.printf("%s %d%n", result.getString("name"), result.getInt("age"));
        }
    }

    private static void connectToDatabase() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
    private static void updateMinion(int minionID) {
        String sql = "UPDATE minions " +
                "SET name = LOWER(name), age = age + 1 " +
                "WHERE id = ?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, String.valueOf(minionID));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("");
        }
    }
}