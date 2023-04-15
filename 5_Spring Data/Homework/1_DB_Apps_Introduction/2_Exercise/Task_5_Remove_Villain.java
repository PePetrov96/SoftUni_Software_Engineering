package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Task_5_Remove_Villain {
    private static Connection connection;
    private static String villainName = "";
    private static int villainID;
    private static int minionCount;

    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        villainID = Integer.parseInt(reader.readLine());

        connectToDatabase();

        removeVillain();

        System.out.printf("%s was deleted%n", villainName);
        System.out.printf("%d minions released", minionCount);
    }

    private static void removeVillain() throws SQLException {
        getMinionCount();

        connection.setAutoCommit(false);

        try {
            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ? ");
            statement2.setInt(1, villainID);
            statement2.executeUpdate();

            PreparedStatement statement1 = connection.prepareStatement("DELETE FROM villains WHERE id = ?; ");
            statement1.setInt(1, villainID);
            statement1.executeUpdate();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    private static void connectToDatabase() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }
    private static void getMinionCount() throws SQLException {
        String sql = "SELECT v.name AS 'villain name', " +
                "       COUNT(minion_id) AS 'minion count' " +
                "FROM villains AS v " +
                "JOIN minions_villains AS mv " +
                "    ON v.id = mv.villain_id " +
                "WHERE v.id = ?;";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, villainID);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            minionCount = result.getInt("minion count");

            String name = result.getString("villain name");

            if (name == null) {
                System.out.println("No such villain was found");
                System.exit(0);
            } else {
                villainName = name;
            }
        }
    }
}