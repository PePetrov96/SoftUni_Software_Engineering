import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task_1_Meeting {
    static Stack<Integer> males;
    static ArrayDeque<Integer> females;
    static int matches;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        initialize();

        match();

        printResult();
    }

    private static void printResult() {
        System.out.println("Matches: " + matches);

        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            Collections.reverse(males);
            System.out.println("Males left: " + males.toString().replaceAll("[\\[\\]]", ""));
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + females.toString().replaceAll("[\\[\\]]", ""));
        }
    }
    private static void match() {
        while (!males.isEmpty() && !females.isEmpty()) {
            int male = males.pop();
            int female = females.remove();

            if (male == female) {
                matches++;
            } else {
                if (male - 2 > 0) {
                    males.push(male-2);
                }
            }

        }
    }
    private static void initialize() throws IOException {
        males = new Stack<>();
        females = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(value -> value > 0 && value % 25 != 0)
                .forEach(males::push);

        Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(value -> value > 0 && value % 25 != 0)
                .forEach(females::add);
    }
}