import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Task_7_Cities_by_Continent_and_Country {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> places = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            if (!places.containsKey(input[0])) {
                places.put(input[0], new LinkedHashMap<>());
                places.get(input[0]).put(input[1], new ArrayList<>());
            } else if (places.containsKey(input[0]) && !places.get(input[0]).containsKey(input[1])) {
                places.get(input[0]).put(input[1], new ArrayList<>());
            }

            places.get(input[0]).get(input[1]).add(input[2]);
        }

        places
                .forEach((continent, value) -> {
                    System.out.println(continent + ":");

                    value
                            .forEach((country, cities) -> {
                                System.out.printf("  %s -> ", country);
                                System.out.print(cities.toString().replaceAll("[\\[\\]]", ""));
                                System.out.println();
                            });
                });
    }
}