package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (getFishInPool() < this.capacity &&
                findFish(fish.getName()) == null) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish fish = findFish(name);
        this.fishInPool.remove(fish);
        return fish != null;
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream()
                .filter(fish -> fish.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report() {
        StringBuilder result = new StringBuilder() // "Aquarium Info:"
                .append(System.lineSeparator())
                .append(String.format("Aquarium: %s ^ Size: %d", this.name, this.size))
                .append(System.lineSeparator());

        fishInPool.forEach(fish ->
                result.append(fish)
                .append(System.lineSeparator()));

        return result.toString().trim();
    }
}