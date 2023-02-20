import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task_1_Apocalypse_Preparation {
    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayDeque<Integer> textiles;
    static Stack<Integer> medicaments;
    static Map<String, Integer> items;

    public static void main(String[] args) throws IOException {
        initialize();

        mix();

        printResult();
    }
    private static void printResult() {
        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        items.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .filter(item -> item.getValue() > 0)
                .forEach(key -> System.out.println(key.getKey() + " - " + key.getValue()));

        if (!medicaments.isEmpty()) {
            Collections.reverse(medicaments);
            System.out.println("Medicaments left: " + medicaments.toString().replaceAll("[\\[\\]]",""));
        }

        if (!textiles.isEmpty()) {
            System.out.println("Textiles left: " + textiles.toString().replaceAll("[\\[\\]]",""));
        }

    }
    private static void mix() {
        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.pop();
            int medicament = medicaments.pop();

            int sum = textile + medicament;

            switch (sum) {
                case 30:
                    items.put("Patch", items.get("Patch") + 1);
                    break;
                case 40:
                    items.put("Bandage", items.get("Bandage") + 1);
                    break;
                case 100:
                    items.put("MedKit", items.get("MedKit") + 1);
                    break;
                default:
                    if (sum > 100) {
                        items.put("MedKit", items.get("MedKit") + 1);
                        medicaments.push(medicaments.pop() + sum - 100);
                    } else {
                        medicaments.push(medicament + 10);
                    }
            }
        }
    }
    private static void initialize() throws IOException {
        items = new LinkedHashMap<>();
        items.put("Patch", 0);
        items.put("Bandage", 0);
        items.put("MedKit", 0);

        textiles = Arrays.stream(reader.readLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        medicaments = Arrays.stream(reader.readLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));
    }
}