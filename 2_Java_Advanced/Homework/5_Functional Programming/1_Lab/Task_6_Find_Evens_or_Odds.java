import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Task_6_Find_Evens_or_Odds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] limits = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String condition = reader.readLine();

        System.out.println(result(limits, condition));
    }
    private static String result (int[] borders, String evenOrOdd) {
        Predicate<Integer> isEven = x -> x % 2 == 0;

        BiFunction<int[], String, String> filtering = (filter, condition) -> {
            StringBuilder result = new StringBuilder();

            for (int i = filter[0]; i <= filter[1]; i++) {
                if (condition.equals("odd") && !isEven.test(i)) {
                    result.append(i).append(" ");
                } else if (condition.equals("even") && isEven.test(i)){
                    result.append(i).append(" ");
                }
            }

            return String.valueOf(result);
        };

        return filtering.apply(borders, evenOrOdd);
    }
}