package Task_5_Football_Team_Generator;

import java.util.LinkedHashMap;

public class TeamsList {
    private final LinkedHashMap<String, Team> teams;

    public TeamsList() {
        this.teams = new LinkedHashMap<>();
    }

    public void addTeam(String teamName) {
        if (!this.teams.containsKey(teamName)) {
            this.teams.put(teamName, new Team(teamName));
        }
    }

    public void getRating(String teamName) {
        if (this.teams.containsKey(teamName) && this.teams.get(teamName).getSize() != 0) {
            System.out.printf("%s - %.0f%n", teamName, this.teams.get(teamName).getRating());
        } else if (!this.teams.containsKey(teamName)) {
            System.out.printf("Team %s does not exist.%n", teamName);
        } else {
            System.out.println(teamName + " - 0");
        }
    }

    public void addPlayer(String[] paste) {
        String teamName = paste[0];
        String playerName = paste[1];
        int endurance = Integer.parseInt(paste[2]);
        int sprint = Integer.parseInt(paste[3]);
        int dribble = Integer.parseInt(paste[4]);
        int passing = Integer.parseInt(paste[5]);
        int shooting = Integer.parseInt(paste[6]);

        if (!this.teams.containsKey(teamName)) {
            System.out.printf("Team %s does not exist.%n", teamName);
            return;
        }

        try {
            this.teams.get(teamName).addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void removePlayer(String teamName, String playerName) {
        try {
            this.teams.get(teamName).removePlayer(playerName);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}