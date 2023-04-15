package com.task;

import java.sql.*;
import java.util.Properties;

public class Task_1_Get_Villains_Names {
    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection
                .prepareStatement(
                        "SELECT v.name AS 'name', " +
                        "COUNT(DISTINCT mv.minion_id) AS 'minionsCount' " +
                        "FROM villains AS v " +
                        "JOIN minions_villains AS mv " +
                        "ON v.id = mv.villain_id GROUP BY v.name ORDER BY minionsCount DESC;");

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.println(
                    result.getString("name") + " " + result.getString("minionsCount")
            );
        }

        connection.close();
    }
}