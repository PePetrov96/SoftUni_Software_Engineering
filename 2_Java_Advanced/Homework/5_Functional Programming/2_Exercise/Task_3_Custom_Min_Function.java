import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class Task_3_Custom_Min_Function {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<Integer[], Integer> minNumber = numbers -> Collections.min(Arrays.asList(numbers));

        String[] input = reader.readLine().split("\\s+");
        Integer[] numberArray = new Integer[input.length];

        for (int i = 0; i < input.length; i++)
            numberArray[i] = Integer.parseInt(input[i]);

        System.out.println(minNumber.apply(numberArray));
    }
}