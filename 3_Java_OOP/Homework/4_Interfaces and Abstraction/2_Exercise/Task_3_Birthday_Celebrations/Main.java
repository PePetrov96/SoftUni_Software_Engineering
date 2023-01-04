package Task_3_Birthday_Celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Birthable> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!"End".equals(input = reader.readLine())) {
            add(input);
        }

        String year = reader.readLine();

        list.stream()
                .filter(entry -> entry.getBirthDate().endsWith(year))
                .forEach(entry -> System.out.println(entry.getBirthDate()));
    }
    private static void add(String input) {
        String command = input.substring(0, input.indexOf(' '));
        String[] tokens = input.substring(input.indexOf(' ')+1).split("\\s");

        String name; int age; String id; String birthDate;

        switch (command) {
            case "Citizen":
                name = tokens[0];
                age = Integer.parseInt(tokens[1]);
                id = tokens[2];
                birthDate = tokens[3];

                list.add(new Citizen(name, age, id, birthDate));
                break;
            case "Pet":
                name = tokens[0];
                birthDate = tokens[1];

                list.add(new Pet(name, birthDate));
                break;
            default:
                break;
        }
    }
}