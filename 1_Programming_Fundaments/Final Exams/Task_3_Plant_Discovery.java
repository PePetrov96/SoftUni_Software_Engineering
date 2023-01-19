import java.util.*;

public class Task_3_Plant_Discovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, PlantSpecs> plantsMap = new LinkedHashMap<>();
        String input = scan.nextLine();

        for (int i = 0; i < Integer.parseInt(input); i++) {
            addPlant(plantsMap, scan.nextLine().split("\\s*<->\\s*"));
        }

        while (!"Exhibition".equals(input = scan.nextLine())) {
            modifyPlants(plantsMap, input.split("\\s*:\\s*")[0], input.split("\\s*:\\s*")[1].split("\\s*-\\s*"));
        }

        print(plantsMap);
    }
    private static void addPlant (Map<String, PlantSpecs> plantsMap, String[] tokens) {
        String plantName = tokens[0];

        if (!plantsMap.containsKey(plantName)) {
            PlantSpecs specs = new PlantSpecs();
            specs.rarity = Integer.parseInt(tokens[1]);
            specs.ratings = new ArrayList<>();
            plantsMap.put(plantName, specs);
        } else {
            plantsMap.get(plantName).rarity = Integer.parseInt(tokens[1]);
        }
    }

    private static void modifyPlants (Map<String, PlantSpecs> plantsMap, String command, String[] tokens) {
        String plantName = tokens[0];

        if (plantsMap.containsKey(plantName)) {
            switch (command) {
                case "Rate":
                    plantsMap.get(plantName).ratings.add(Integer.parseInt(tokens[1]));
                    break;
                case "Update":
                    plantsMap.get(plantName).rarity = Integer.parseInt(tokens[1]);
                    break;
                case "Reset":
                    plantsMap.get(plantName).ratings.clear();
                    break;
            }
        } else {
            System.out.println("error");
        }
    }
    private static void print (Map<String, PlantSpecs> plantsMap) {
        System.out.println("Plants for the exhibition:");
        plantsMap.forEach((key, value) -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", key, value.rarity, value.getAverageRatings()));
    }
    private static class PlantSpecs {
        int rarity;
        List<Integer> ratings;

        public double getAverageRatings() {
            int sum = ratings.stream().mapToInt(Integer::intValue).sum();
            int divider = ratings.size();
            if (sum == 0) {
                return 0.0;
            } else {
                return (double) sum / divider;
            }
        }
    }
}