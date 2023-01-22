package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area{
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(this.animals);
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(this.foods);
    }

    @Override
    public int sumCalories() {
        return Math.max(0, this.foods.stream()
                .mapToInt(Food::getCalories)
                .sum());
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() >= this.capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        this.animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder out = new StringBuilder(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());

        if (animals.size() == 0) {
            out.append("Animals: none");
        } else {
            out.append("Animals: ")
                    .append(animals.stream()
                            .map(Animal::getName)
                            .collect(Collectors.joining(" ")));
        }

        out.append(System.lineSeparator())

                .append(String.format("Foods: " + foods.size()))
                .append(System.lineSeparator())

                .append(String.format("Calories: " + sumCalories()))
                .append(System.lineSeparator());

        return out.toString().trim();
    }
}