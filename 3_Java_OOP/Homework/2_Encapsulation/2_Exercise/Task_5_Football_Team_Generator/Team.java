package Task_5_Football_Team_Generator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String planerName) {
        for (Player player : players) {
            if (player.getName().equals(planerName)) {
                players.remove(player);
                return;
            }
        }
        throw new IllegalArgumentException(String.format("Player %s is not in %s team.", planerName, this.name));
    }

    public double getRating() {
        double average = this.players.stream().mapToDouble(Player::overallSkillLevel).sum() / this.players.size();
        return average > 0 ? average : 0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private List<Player> getPlayers() {
        return players;
    }

    private void setPlayers(List<Player> players) {
        this.players = players;
    }
    public int getSize() {
        return this.players.size();
    }
}