import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task_8_Custom_Comparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> result = new ArrayDeque<>();

        input
                .stream()
                .filter(i -> i % 2 != 0)
                .sorted()
                .forEach(result::offer);

        input
                .stream()
                .filter(i -> i % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .forEach(result::push);

        result.forEach(i -> System.out.print(i + " "));
    }
}