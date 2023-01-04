package Task_5_Border_Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Identifiable> city = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"End".equals(input = reader.readLine())) {
            add(input.split("\\s"));
        }

        printFakeIdInCity(reader.readLine());
    }

    private static void add(String[] input) {
        if (input.length == 2) {
            String model = input[0];
            String id = input[1];

            city.add(new Robot(model, id));
        } else {
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String id = input[2];

            city.add(new Citizen(name, age, id));
        }
    }
    private static void printFakeIdInCity(String lastDigit) {
        city.stream()
                .filter(elem -> elem.getId().endsWith(lastDigit))
                .forEach(elem -> System.out.println(elem.getId()));
    }
}