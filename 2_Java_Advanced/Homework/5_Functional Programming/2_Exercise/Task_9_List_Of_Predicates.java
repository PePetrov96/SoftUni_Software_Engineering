import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class Task_9_List_Of_Predicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<int[], Integer> filter = (dividers, number) -> {
            for (int divider : dividers)
                if (number % divider != 0) return false;
            return true;
        };

        int upTo = Integer.parseInt(reader.readLine());
        int[] dividers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= upTo; i++)
            if (filter.test(dividers, i))
                System.out.print(i + " ");
    }
}