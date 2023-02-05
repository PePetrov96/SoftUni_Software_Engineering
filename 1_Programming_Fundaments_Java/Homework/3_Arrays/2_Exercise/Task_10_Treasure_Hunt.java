import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_10_Treasure_Hunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Yohoho!".equals(line)) {
            List<String> treasure = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            String command = treasure.get(0);

            switch (command) {
                case "Loot":
                    for (int i = 1; i < treasure.size(); i++) {
                        if (!initialLoot.contains(treasure.get(i))) {
                            initialLoot.add(0, treasure.get(i));
                        }
                    }

                    break;
                case "Drop":
                    int index = Integer.parseInt(treasure.get(1));

                    if (index >= 0 && index < initialLoot.size()) {
                        String item = initialLoot.get(index);
                        initialLoot.remove(index);
                        initialLoot.add(item);
                    }

                    break;
                case "Steal":
                    int count = Integer.parseInt(treasure.get(1));

                    if (count > initialLoot.size()) {
                        count = initialLoot.size();
                    }

                    List<String> subList = initialLoot.subList(initialLoot.size() - count, initialLoot.size());

                    System.out.println(String.join(", ", subList));

                    initialLoot = initialLoot.subList(0, initialLoot.size() - count);

                    break;
            }

            line = scanner.nextLine();
        }

        if (!initialLoot.isEmpty()) {
            int sumLengthItem = 0;

            for (String currentItem : initialLoot) {
                sumLengthItem += currentItem.length();
            }

            double averageGain = sumLengthItem * 1.0 / initialLoot.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averageGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}