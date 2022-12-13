import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_13_Dragon_Army {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Stats>> dragonList = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {
            updateEntry(dragonList, reader.readLine());
        }

        sortAndPrintResult(dragonList);
    }
    private static void sortAndPrintResult (LinkedHashMap<String, LinkedHashMap<String, Stats>> dragonList) {
        dragonList
                .forEach((type, names) -> {
                    double averageDamage = names
                            .values()
                            .stream()
                            .mapToDouble(i -> i.damage)
                            .sum() / names.size();
                    double averageHealth = names
                            .values()
                            .stream()
                            .mapToDouble(i -> i.health)
                            .sum() / names.size();
                    double averageArmor = names
                            .values()
                            .stream()
                            .mapToDouble(i -> i.armor)
                            .sum() / names.size();
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averageDamage, averageHealth, averageArmor);

                    names
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(name -> System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",
                                    name.getKey(),
                                    name.getValue().damage,
                                    name.getValue().health,
                                    name.getValue().armor));
                });
    }
    private static void updateEntry (LinkedHashMap<String, LinkedHashMap<String, Stats>> dragonList, String input) {
        Pattern p = Pattern.compile("(?<type>[A-Za-z]+)\\s+(?<name>[A-Za-z]+)\\s+(?<damage>\\d+|null)\\s+(?<health>\\d+|null)\\s+(?<armor>\\d+|null)");
        Matcher m = p.matcher(input);

        if (m.find()) {
            String type = m.group("type");
            String name = m.group("name");

            double damage = !m.group("damage").equals("null") ? Integer.parseInt(m.group("damage")) : 45;
            double health = !m.group("health").equals("null") ? Integer.parseInt(m.group("health")) : 250;
            double armor = !m.group("armor").equals("null") ? Integer.parseInt(m.group("armor")) : 10;

            Stats stats = new Stats(damage, health, armor);
            dragonList.putIfAbsent(type, new LinkedHashMap<>());
            dragonList.get(type).put(name, stats);
        }
    }
    private static class Stats {
        double damage;
        double health;
        double armor;
        public Stats(double damage, double health, double armor) {
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }
    }
}