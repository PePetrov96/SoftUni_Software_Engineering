import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Task_2_Sum_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(",\\s+");

        int sum = 0;
        Function<String, Integer> parser = Integer::parseInt;

        if (input.length < 2) {
            sum = parser.apply(input[0]);
        } else {
            for (String s : input) sum += parser.apply(s);
        }

        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}