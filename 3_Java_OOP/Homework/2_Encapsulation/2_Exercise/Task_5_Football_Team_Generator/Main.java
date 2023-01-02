package Task_5_Football_Team_Generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TeamsList teamsList = new TeamsList();

        String input;
        while (!"END".equals(input = reader.readLine().trim())) {
            String command = input.substring(0, input.indexOf(';'));
            String[] tokens = input.substring(input.indexOf(';')+1).trim().split(";");

            switch (command) {
                case "Team": teamsList.addTeam(tokens[0]); break;
                case "Add": teamsList.addPlayer(tokens); break;
                case "Remove": teamsList.removePlayer(tokens[0], tokens[1]); break;
                case "Rating": teamsList.getRating(tokens[0]); break;
            }
        }
    }
}