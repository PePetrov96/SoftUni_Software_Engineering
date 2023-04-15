package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class Task_3_Add_Minion {
    private static String[] minion;
    private static String villain;
    private static Connection connection;
    public static void main(String[] args) throws SQLException, IOException {

        connectToDatabase();

        readInput();

        addEntries();

    }
    private static void connectToDatabase() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
    }

    private static void readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        minion = Arrays.stream(reader.readLine().split(":\\s|\\s")).skip(1).toArray(String[]::new);
        villain = reader.readLine().split(":\\s")[1];
    }

    private static void addEntries() throws SQLException {
        if (!hasTown()) {
            addTown();
        }

        if (!hasVillain()) {
            addVillain();
        }

        if (!hasMinion()) {
            addMinion();
        }
    }

    private static boolean hasVillain() throws SQLException {
        PreparedStatement statementVillain = connection.prepareStatement(
                "SELECT name " +
                        "FROM villains " +
                        "WHERE name = ?");

        statementVillain.setString(1, villain);

        ResultSet resultVillain = statementVillain.executeQuery();

        return resultVillain.next();
    }

    private static boolean hasMinion() throws SQLException {
        PreparedStatement statementMinion = connection.prepareStatement(
                "SELECT name " +
                        "FROM minions " +
                        "WHERE name = ?");

        statementMinion.setString(1, minion[0]);

        ResultSet resultMinion = statementMinion.executeQuery();

        return resultMinion.next();
    }

    private static boolean hasTown() throws SQLException {
        PreparedStatement statementTown = connection.prepareStatement(
                "SELECT name " +
                        "FROM towns " +
                        "WHERE name = ?");

        statementTown.setString(1, minion[2]);

        ResultSet resultTown = statementTown.executeQuery();

        return resultTown.next();
    }

    private static void addTown() throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO towns (name) " +
                        "VALUE (?)");

        statement.setString(1, minion[2]);
        statement.executeUpdate();

        System.out.printf("Town %s was added to the database%n", minion[2]);
    }

    private static void addMinion() throws SQLException {
        // Insert a new minion into the minions table and retrieve its ID
        PreparedStatement insertMinionStmt = connection.prepareStatement(
                    "INSERT INTO minions (name, age, town_id) " +
                            "VALUE (?, ?, (SELECT id FROM towns WHERE towns.name = ?))", Statement.RETURN_GENERATED_KEYS);

        insertMinionStmt.setString(1, minion[0]);
        insertMinionStmt.setString(2, minion[1]);
        insertMinionStmt.setString(3, minion[2]);

        insertMinionStmt.executeUpdate();
        ResultSet minionIdResultSet = insertMinionStmt.getGeneratedKeys();
        minionIdResultSet.next();

        int minionId = minionIdResultSet.getInt(1);


        // Get the ID of the desired villain
        PreparedStatement getVillainIdStmt = connection.prepareStatement(
                    "SELECT id " +
                            "FROM villains " +
                            "WHERE name = ?");

        getVillainIdStmt.setString(1, villain);

        ResultSet villainIdResultSet = getVillainIdStmt.executeQuery();
        villainIdResultSet.next();

        int villainId = villainIdResultSet.getInt("id");


        // Insert a new row into the minion_villain table that links the minion with the villain
        PreparedStatement insertMinionVillainStmt = connection.prepareStatement(
                    "INSERT INTO minions_villains (minion_id, villain_id) " +
                            "VALUES (?, ?)");

        insertMinionVillainStmt.setInt(1, minionId);
        insertMinionVillainStmt.setInt(2, villainId);
        insertMinionVillainStmt.executeUpdate();


        System.out.printf("Successfully added %s to be minion of %s%n", minion[0], villain);
    }

    private static void addVillain() throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO villains (name, evilness_factor) " +
                "VALUE (?, 'evil')");

        statement.setString(1, villain);
        statement.executeUpdate();


        System.out.printf("Villain %s was added to the database.%n", villain);
    }
}