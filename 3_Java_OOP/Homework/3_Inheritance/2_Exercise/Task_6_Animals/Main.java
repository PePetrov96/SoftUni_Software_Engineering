package Task_6_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"Beast!".equals(input = reader.readLine())) {
            String[] tokens = reader.readLine().split("\\s+");

            Animal animal;
            try {

                switch (input) {
                    case "Frog": animal = tryCreateFrog(tokens); break;
                    case "Dog": animal = tryCreateDog(tokens); break;
                    case "Cat": animal = tryCreateCat(tokens); break;
                    case "Kitten": animal = tryCreateKitten(tokens); break;
                    case "Tomcat": animal = tryCreateTomcat(tokens); break;
                    default: throw new IllegalArgumentException("Invalid input!");
                }

                System.out.println(animal);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static Tomcat tryCreateTomcat(String[] input) {
        String name = input[0];
        int age = Integer.parseInt(input[1]);
        return new Tomcat(name, age);
    }

    private static Kitten tryCreateKitten(String[] input) {
        String name = input[0];
        int age = Integer.parseInt(input[1]);
        return new Kitten(name, age);
    }

    private static Cat tryCreateCat(String[] input) {
        String name = input[0];
        int age = Integer.parseInt(input[1]);
        String gender = input[2];
        return new Cat(name, age, gender);
    }

    private static Dog tryCreateDog(String[] input) {
        String name = input[0];
        int age = Integer.parseInt(input[1]);
        String gender = input[2];
        return new Dog(name, age, gender);
    }

    private static Frog tryCreateFrog(String[] input) {
        String name = input[0];
        int age = Integer.parseInt(input[1]);
        String gender = input[2];
        return new Frog(name, age, gender);
    }
}