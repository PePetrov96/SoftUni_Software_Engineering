package shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        setData();
        this.setCapacity(capacity);
    }

    public void add(Animal animal) {
        if (getCount() < this.capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream()
                .filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }

    public Animal getOldestAnimal() {
        return this.data.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder("The shelter has the following animals:")
                .append(System.lineSeparator());

        this.data.forEach(animal ->
                result.append(animal.getName())
                        .append(" ")
                        .append(animal.getCaretaker())
                        .append(System.lineSeparator()));

        return result.toString();
    }

    public List<Animal> getData() {
        return Collections.unmodifiableList(data);
    }

    public int getCapacity() {
        return capacity;
    }
    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setData() {
        this.data = new ArrayList<>();
    }
}
