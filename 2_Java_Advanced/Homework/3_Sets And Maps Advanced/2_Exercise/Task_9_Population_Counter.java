import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task_9_Population_Counter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Long>> countriesMap = new LinkedHashMap<>();

        String input;
        while (!"report".equals(input = reader.readLine())) {
            updateEntries(countriesMap, input.split("\\|"));
        }

        printResult(countriesMap);

    }
    private static void printResult (HashMap<String, LinkedHashMap<String, Long>> countriesMap) {
        LinkedHashMap<String, Long> countriesOnly = new LinkedHashMap<>();

        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : countriesMap.entrySet()) {
            String country = entry.getKey();
            long population = entry.getValue().values().stream().mapToLong(i -> i).sum();
            countriesOnly.put(country, population);
        }

        countriesMap
                .entrySet()
                .stream()
                .sorted((Map.Entry<String, LinkedHashMap<String, Long>> e1, Map.Entry<String, LinkedHashMap<String, Long>> e2) -> {
                    int n = countriesOnly.get(e2.getKey()).compareTo(countriesOnly.get(e1.getKey()));
                    if (n == 0) {
                        return 1;
                    }
                    return n;
                })
                .forEach(key -> {
                    System.out.printf("%s (total population: %d)%n"
                            ,key.getKey()
                            ,countriesOnly.get(key.getKey()));
                    key.getValue()
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(key2 -> System.out.printf("=>%s: %d%n", key2.getKey(), key2.getValue()));
                });
    }
    private static void updateEntries (HashMap<String, LinkedHashMap<String, Long>> countriesMap, String[] tokens) {
        String country = tokens[1];
        String city = tokens[0];
        long population = Integer.parseInt(tokens[2]);

        if (!countriesMap.containsKey(country)) {
            countriesMap.put(country, new LinkedHashMap<>());
        }

        countriesMap.get(country).put(city, population);
    }
}