package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Task_8_Increase_Age_Stored_Procedure {
    private static Connection connection;
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        connectToDatabase();

        int minionID = Integer.parseInt(reader.readLine());

        updateMinion(minionID);
    }
    private static void connectToDatabase() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }

    private static void updateMinion(int minionID) {
        String sql = "{CALL usp_get_older(?)}";

        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setInt(1, minionID);
            statement.execute();
        } catch (SQLException e) {
            System.out.print("");
        }
    }
}