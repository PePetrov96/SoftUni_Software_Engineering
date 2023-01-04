package Task_4_Food_Shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Buyer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        for (int i = 0; i < Integer.parseInt(input); i++) {
            add(reader.readLine());
        }

        while (!"End".equals(input = reader.readLine())) {
            buy(input);
        }

        print();

    }
    private static void print() {
        System.out.println(list.stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }

    private static void buy(String name) {
        list.stream()
                .filter(buyer -> buyer.getName().equals(name))
                .forEach(Buyer::buyFood);
    }
    private static void add(String input) {
        String[] tokens = input.split("\\s+");
        if (tokens.length == 3) {
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String group = tokens[2];

            list.add(new Rebel(name, age, group));
        } else {
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String id = tokens[2];
            String birthDate = tokens[3];

            list.add(new Citizen(name, age, id, birthDate));
        }
    }
}