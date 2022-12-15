import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class Task_1_Consumer_Print {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> print = System.out::println;

        String[] input = reader.readLine().split("\\s+");

        for (String name : input) print.accept(name);
    }
}