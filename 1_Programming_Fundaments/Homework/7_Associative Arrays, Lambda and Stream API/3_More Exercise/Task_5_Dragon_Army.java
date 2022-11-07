import java.util.*;

public class Task_5_Dragon_Army {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 1; i <= input; i++) {
            updateList(dragons, scanner.nextLine().split(" "));
        }

        printOutput(dragons);
    }
    private static void updateList (Map<String, Map<String, int[]>> dragons, String[] dragonData) {
        String type = dragonData[0];
        String name = dragonData[1];
        int damage = dragonData[2].equals("null") ? 45 : Integer.parseInt(dragonData[2]);
        int health = dragonData[3].equals("null") ? 250 : Integer.parseInt(dragonData[3]);
        int armor = dragonData[4].equals("null") ? 10 : Integer.parseInt(dragonData[4]);

        Map<String, int[]> nameAndStats = new TreeMap<>();
        int[] stats = new int[3];
        stats[0] = damage;
        stats[1] = health;
        stats[2] = armor;
        nameAndStats.put(name, stats);

        if (!dragons.containsKey(type)) {
            dragons.put(type, nameAndStats);
        } else {
            dragons.get(type).remove(name);
            dragons.get(type).put(name, stats);
        }
    }
    private static void printOutput (Map<String, Map<String, int[]>> dragons) {
        dragons.forEach((key, value) -> {
            double damageAvg = 0;
            double healthAvg = 0;
            double armorAvg = 0;
            for (int[] ints : value.values()) {
                damageAvg += ints[0];
                healthAvg += ints[1];
                armorAvg += ints[2];
            }
            damageAvg /= value.size();
            healthAvg /= value.size();
            armorAvg /= value.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", key, damageAvg, healthAvg, armorAvg);
            dragons.get(key).forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", k, v[0], v[1], v[2]));
        });
    }
}