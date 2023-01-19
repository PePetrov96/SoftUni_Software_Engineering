package sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.setCapacity(capacity);
        this.setData();
    }

    public void add(Elephant elephant) {
        if (this.getAllElephants() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant elephant : this.data) {
            if (elephant.getName().equals(name)) {
                this.data.remove(elephant);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        return this.data.stream()
                .filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }

    public Elephant getOldestElephant() {
        return this.data.stream()
                .max(Comparator.comparingInt(Elephant::getAge))
                .orElse(null);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder result = new StringBuilder("Saved elephants in the park:").append(System.lineSeparator());

        this.data.forEach(elephant ->
                result.append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom()))
                        .append(System.lineSeparator()));

        return result.toString();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Elephant> getData() {
        return Collections.unmodifiableList(this.data);
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setData() {
        this.data = new ArrayList<>();
    }
}