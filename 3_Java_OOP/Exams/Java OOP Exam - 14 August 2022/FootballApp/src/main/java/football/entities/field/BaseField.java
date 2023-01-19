package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseField implements Field{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return Math.max(0,
                this.supplements.stream()
                        .mapToInt(Supplement::getEnergy)
                        .sum());
    }

    @Override
    public void addPlayer(Player player) {
        if (this.players.size() >= capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY);
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void drag() {
        this.players.forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder result = new StringBuilder(
                String.format("%s (%s):", this.name, getClass().getSimpleName()))
                .append(System.lineSeparator());

        if (players.size() == 0) {
            result.append("Player: none");
        } else {
            result.append("Player: ");
            players.forEach(player -> result.append(player.getName()).append(" "));
            result.deleteCharAt(result.length()-1);
        }

        result.append(System.lineSeparator())
                .append("Supplement: ").append(supplements.size())
                .append(System.lineSeparator())
                .append("Energy: ").append(sumEnergy());

        return result.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
}