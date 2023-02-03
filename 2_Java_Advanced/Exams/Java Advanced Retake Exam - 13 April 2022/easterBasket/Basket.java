package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (getCount() < this.capacity) {
            this.data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        Egg egg = this.getEgg(color);
        if (egg != null) {
            this.data.remove(egg);
        }
        return egg != null;
    }

    public Egg getStrongestEgg() {
        return this.data.stream()
                .max(Comparator.comparingInt(Egg::getStrength))
                .orElse(null);
    }

    public Egg getEgg(String color) {
        return this.data.stream()
                .filter(egg -> egg.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder(this.material)
                .append(" basket contains:")
                .append(System.lineSeparator());

        this.data.forEach(egg -> result.append(egg.toString())
                .append(System.lineSeparator()));

        return result.toString().trim();
    }
}