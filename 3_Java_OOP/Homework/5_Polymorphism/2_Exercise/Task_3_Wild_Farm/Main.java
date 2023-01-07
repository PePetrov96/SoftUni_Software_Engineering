package Task_3_Wild_Farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Animal animal = null;
    static Food food = null;
    static List<Animal> animalList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"End".equals(input = reader.readLine())) {
            getAnimal(input.split("\\s+"));
            getFood(reader.readLine().split("\\s+"));

            animal.eat(food);
        }

        animalList.forEach(System.out::println);
    }
    private static void getFood(String[] input) {
        String type = input[0];
        int quantity = Integer.parseInt(input[1]);

        switch (type) {
            case "Meat": food = new Meat(quantity); break;
            case "Vegetable": food = new Vegetable(quantity); break;
        }

    }
    private static void getAnimal(String[] input) {
        String type = input[0];
        String name = input[1];
        double weight = Double.parseDouble(input[2]);
        String region = input[3];

        if (input.length == 5) {
            animal = new Cat(name, type, weight, region, input[4]);
        } else {
            switch (type) {
                case "Mouse": animal = new Mouse(name, type, weight, region); break;
                case "Zebra": animal = new Zebra(name, type, weight, region); break;
                case "Tiger": animal = new Tiger(name, type, weight, region); break;
            }
        }

        if (animal != null) {
            animal.makeSound();
        }

        animalList.add(animal);
    }
}