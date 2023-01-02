package Task_3_Shopping_Spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Map<String, Person> peopleMap = new LinkedHashMap<>();
    private static Map<String, Product> productsMap = new LinkedHashMap<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        addPeople();
        addProducts();

        String commands;
        while (!"END".equals(commands = reader.readLine())) {
            String[] tokens = commands.split("\\s+");
            Person person = peopleMap.get(tokens[0]);
            Product product = productsMap.get(tokens[1]);

            person.buyProduct(product);
        }

        peopleMap.values().forEach(System.out::println);
    }
    private static void addPeople() throws IOException {
        String[] input = reader.readLine().split("[=;]");

        for (int i = 0; i < input.length; i += 2) {
            String name = input[i];
            double money = Double.parseDouble(input[i+1]);
            peopleMap.putIfAbsent(name, new Person(name, money));
        }
    }

    private static void addProducts() throws IOException {
        String[] input = reader.readLine().split("[=;]");

        for (int i = 0; i < input.length; i += 2) {
            String name = input[i];
            double cost = Double.parseDouble(input[i+1]);
            productsMap.putIfAbsent(name, new Product(name, cost));
        }
    }
}