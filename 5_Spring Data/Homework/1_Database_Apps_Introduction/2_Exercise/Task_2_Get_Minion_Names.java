package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Task_2_Get_Minion_Names {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection
                .prepareStatement(
                        "SELECT v.name AS 'villain name'," +
                        "           m.name AS 'minion name'," +
                        "           m.age AS 'minion age'" +
                        "FROM minions AS m " +
                        "JOIN minions_villains AS mv " +
                        "    ON m.id = mv.minion_id " +
                        "JOIN villains AS v " +
                        "    ON v.id = mv.villain_id " +
                        "WHERE mv.villain_id = ? " +
                        "GROUP BY v.name, m.name, m.age;");


        String villainID = reader.readLine();
        statement.setString(1, villainID);
        ResultSet result = statement.executeQuery();

        Map<String, Integer> minions = new LinkedHashMap<>();

        String villainName = null;
        
        while (result.next()) {
            villainName = result.getString("villain name");
            if (villainName == null) {
                break;
            }
            String name = result.getString("minion name");
            int age = result.getInt("minion age");
            minions.put(name, age);
        }

        if (villainName == null) {
            System.out.printf("No villain with ID %s exists in the database.", villainID);
            return;
        }

        System.out.println("Villain: " + villainName);

        int count = 1;

        for (Map.Entry<String, Integer> minion : minions.entrySet()) {
            System.out.printf("%d. %s %d%n", count++, minion.getKey(), minion.getValue());
        }
    }
}