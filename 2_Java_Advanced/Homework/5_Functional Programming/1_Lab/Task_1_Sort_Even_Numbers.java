import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task_1_Sort_Even_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays
                .stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(integer -> integer % 2 != 0);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]",""));

        numbers.sort(Integer::compareTo);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]",""));
    }
}