package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;

    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (count() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        Parrot parrot = this.data.stream()
                .filter(parrot1 -> parrot1.getName().equals(name))
                .findFirst()
                .orElse(null);

        this.data.remove(parrot);

        return parrot != null;
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream()
                .filter(parrot1 -> parrot1.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (parrot != null) {
            parrot.setAvailable(false);
        }

        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> sold = this.data.stream()
                .filter(parrot -> parrot.getSpecies().equals(species))
                .collect(Collectors.toList());

        for (Parrot parrot : sold) {
            sellParrot(parrot.getName());
        }

        return sold;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder(String.format("Parrots available at %s:", this.name))
                .append(System.lineSeparator());

        this.data.stream()
                .filter(Parrot::isAvailable)
                .forEach(parrot -> result
                .append(parrot)
                .append(System.lineSeparator()));

        return result.toString();
    }

}
