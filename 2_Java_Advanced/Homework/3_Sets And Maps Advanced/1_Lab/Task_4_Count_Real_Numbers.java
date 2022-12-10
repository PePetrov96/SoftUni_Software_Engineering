import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Task_4_Count_Real_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        LinkedHashMap<Double, Integer> result = new LinkedHashMap<>();

        for (Double number : input) {
            if (!result.containsKey(number)) {
                result.put(number, 1);
            } else {
                result.put(number, result.get(number) + 1);
            }
        }

        result.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}