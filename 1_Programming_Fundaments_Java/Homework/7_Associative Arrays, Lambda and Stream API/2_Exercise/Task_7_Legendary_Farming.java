import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_7_Legendary_Farming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> mainMaterials = new LinkedHashMap<>(); mainMaterials.put("shards", 0); mainMaterials.put("fragments", 0); mainMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new LinkedHashMap<>();

        while (true) {
            String[] input = scan.nextLine().split("\\s+");
            boolean isFinal = false;

            for (int i = 0; i < input.length; i++) {
                updateMaterials(mainMaterials, junkMaterials, input, i);
                i++;

                if (returnCheck(mainMaterials)) { isFinal = true; break;}
            }
            if (isFinal) {break;}
        }
        mainMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        junkMaterials.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
    private static void updateMaterials (Map<String, Integer> mainMaterials, Map<String, Integer> junkMaterials, String[] input, int i) {
        int amount = Integer.parseInt(input[i]);
        String material = input[i+1].toLowerCase();

        if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
            mainMaterials.put(material, mainMaterials.get(material) + amount);
        } else if (!junkMaterials.containsKey(material)){
            junkMaterials.put(material, amount);
        } else {
            junkMaterials.put(material, junkMaterials.get(material) + amount);
        }
    }

    private static boolean returnCheck (Map<String, Integer> mainMaterials) {
        for (Map.Entry<String, Integer> material1 : mainMaterials.entrySet()) {
            if (material1.getValue() >= 250) {
                returnUpdate(material1.getKey(), mainMaterials);
                return true;
            }
        }
        return false;
    }
    private static void returnUpdate (String material1, Map<String, Integer> mainMaterials) {
        if ("shards".equals(material1)) {
            System.out.println("Shadowmourne obtained!");
        } else if ("fragments".equals(material1)) {
            System.out.println("Valanyr obtained!");
        } else if ("motes".equals(material1)) {
            System.out.println("Dragonwrath obtained!");
        }
        mainMaterials.put(material1, mainMaterials.get(material1) - 250);
    }
}