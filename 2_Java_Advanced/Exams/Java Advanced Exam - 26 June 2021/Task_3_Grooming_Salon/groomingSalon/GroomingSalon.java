package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private final List<Pet> data;
    private int capacity;
    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (getCount() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < getCount(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet result = null;

        for (Pet pet : data) {
            if (pet.getName().equals(name) &&
                    pet.getOwner().equals(owner)) {
                result = pet;
            }
        }

        return result;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder("The grooming salon has the following clients:")
                .append(System.lineSeparator());

        this.data.forEach(pet -> result
                .append(pet.getName())
                .append(" ")
                .append(pet.getOwner())
                .append(System.lineSeparator()));

        return result.toString().trim();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}