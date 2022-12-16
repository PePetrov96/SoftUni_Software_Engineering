import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> peopleList = new ArrayList<>();

        for (int cycles = 0; cycles < n; cycles++) {
            addPerson(peopleList, reader.readLine().split("\\s+"));
        }

        printResult(peopleList);
    }
    private static void addPerson (List<Person> peopleList, String[] input) {
        String name = input[0];
        int age = Integer.parseInt(input[1]);

        Person person = new Person(name, age);

        if (person.isOldEnough())
            peopleList.add(person);
    }
    private static void printResult (List<Person> peopleList) {
        peopleList.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}