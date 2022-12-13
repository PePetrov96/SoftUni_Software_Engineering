import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Task_11_Legendary_Farming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> keyMaterials = new TreeMap<>(); keyMaterials.put("motes", 0); keyMaterials.put("shards", 0); keyMaterials.put("fragments", 0);
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        do {
            updateEntries(keyMaterials, junkMaterials, reader.readLine().split("\\s+"));
        } while (!gotCheck(keyMaterials));

        printResult(keyMaterials, junkMaterials);
    }
    private static boolean gotCheck (TreeMap<String, Integer> keyMaterials) {
        for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
            if (keyMaterials.get(entry.getKey()) >= 250) {
                return true;
            }
        }
        return false;
    }
    private static void getLegendary (TreeMap<String, Integer> keyMaterials) {
        for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
            String key = entry.getKey();
            if (keyMaterials.get(key) >= 250) {
                keyMaterials.put(key, keyMaterials.get(key) - 250);
                switch (key) {
                    case "motes": System.out.println("Dragonwrath obtained!"); break;
                    case "shards": System.out.println("Shadowmourne obtained!"); break;
                    case "fragments": System.out.println("Valanyr obtained!"); break;
                }
                break;
            }
        }
    }
    private static void printResult (TreeMap<String, Integer> keyMaterials, TreeMap<String, Integer> junkMaterials) {
        getLegendary(keyMaterials);

        keyMaterials
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(key ->
                        System.out.printf("%s: %d%n", key.getKey(), key.getValue()));

        junkMaterials
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(key ->
                        System.out.printf("%s: %d%n", key.getKey(), key.getValue()));
    }
    private static void updateEntries (TreeMap<String, Integer> keyMaterials, TreeMap<String, Integer> junkMaterials, String[] input) {
        for (int cycles = 0; cycles < input.length; cycles++, cycles++) {

            int count = Integer.parseInt(input[cycles]);
            String item = input[cycles+1].toLowerCase();

            if (item.equals("motes") || item.equals("shards") || item.equals("fragments")) {
                keyMaterials.put(item, keyMaterials.get(item) + count);
            } else {
                if (!junkMaterials.containsKey(item)) {
                    junkMaterials.put(item, 0);
                }
                junkMaterials.put(item, junkMaterials.get(item) + count);
            }

            if (gotCheck(keyMaterials)) break;
        }
    }
}