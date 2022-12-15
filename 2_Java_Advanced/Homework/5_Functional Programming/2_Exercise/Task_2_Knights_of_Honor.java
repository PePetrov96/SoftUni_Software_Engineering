import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class Task_2_Knights_of_Honor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> print = message -> System.out.println("Sir " + message);

        String[] input = reader.readLine().split("\\s+");

        for (String name : input) print.accept(name);
    }
}