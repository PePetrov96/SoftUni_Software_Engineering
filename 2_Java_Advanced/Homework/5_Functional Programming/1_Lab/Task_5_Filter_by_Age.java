import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Task_5_Filter_by_Age {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        for (int cycles = 0; cycles < n; cycles++) {
            String[] input = reader.readLine().split(",\\s+");
            people.put(input[0], Integer.parseInt(input[1]));
        }

        String condition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        printFilteredStudents(people, createTester(condition, age), createPrinter(format));
    }
    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name":
                printer = person -> System.out.printf("%s%n", person.getKey());
                break;
            case "age":
                printer = person -> System.out.printf("%d%n", person.getValue());
                break;
            case "name age":
                printer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
                break;
        }
        return printer;
    }
    private static Predicate<Integer> createTester(String condition, int age) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "older": tester = x -> x >= age; break;
            case "younger": tester = x -> x <= age; break;
        }
        return tester;
    }
    private static void printFilteredStudents (LinkedHashMap<String, Integer> people, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey())))
                printer.accept(person);
        }
    }
}