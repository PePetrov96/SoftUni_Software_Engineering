import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Task_2_Sets_of_Elements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] n = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        LinkedHashSet<String> setOne = new LinkedHashSet<>();
        LinkedHashSet<String> setTwo = new LinkedHashSet<>();

        for (int i = 0; i < n[0]; i++) setOne.add(reader.readLine());

        for (int i = 0; i < n[0]; i++) setTwo.add(reader.readLine());

        setOne.retainAll(setTwo);

        setOne.forEach(entry -> System.out.print(entry + " "));
    }
}