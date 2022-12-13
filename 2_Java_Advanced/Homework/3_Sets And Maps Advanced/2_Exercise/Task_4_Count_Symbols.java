import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Task_4_Count_Symbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        TreeMap<Character, Integer> counter = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (!counter.containsKey(input.charAt(i))) {
                counter.put(input.charAt(i), 0);
            }
            counter.put(input.charAt(i), counter.get(input.charAt(i)) + 1);
        }

        counter
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(key -> System.out.printf("%s: %d time/s%n", key.getKey(), key.getValue()));
    }
}
