package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){
        if (getChildrenCount() < this.capacity) {
            this.registry.add(child);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeChild(String firstName){
        return this.registry.remove(getChild(firstName));
    }

    public int getChildrenCount(){
        return this.registry.size();
    }

    public Child getChild(String firstName){
        return this.registry.stream()
                .filter(child -> child.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public String registryReport(){
        this.registry.sort(Comparator.
                comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));

        StringBuilder out = new StringBuilder(String.format("Registered children in %s:", this.name));

        for (Child child : this.registry) {
            out.append(System.lineSeparator())
                    .append("--")
                    .append(System.lineSeparator())
                    .append(child.toString());
        }

        return out.toString().trim();
    }
}