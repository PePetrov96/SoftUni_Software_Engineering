package hotel;

import java.util.ArrayList;
import java.util.Collection;

public class Hotel {
    private String name;
        private int capacity;
    private Collection<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if (getCount() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name){
        Person person = this.roster.stream()
                .filter(person1 -> person1.getName().equals(name))
                .findFirst()
                .orElse(null);

        this.roster.remove(person);

        return person != null;
    }

    public Person getPerson(String name, String hometown){
        return this.roster.stream()
                .filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder(String.format("The people in the hotel %s are:", this.name)).append(System.lineSeparator());

        roster.forEach(person -> result
                .append(person.toString())
                .append(System.lineSeparator()));

        return result.toString();
    }
}