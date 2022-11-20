import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Task_3_Plant_Discovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, PlantSpecs> plantList = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            addPlant(plantList, scan.nextLine().split("\\s*<->\\s*"));
        }

        String input;

        while (!"Exhibition".equals(input = scan.nextLine())) {
            updateGrades(input.split(":\\s*"), plantList);
        }

        printResult(plantList);
    }
    private static void addPlant (LinkedHashMap<String, PlantSpecs> plantList, String[] tokens) {
        String name = tokens[0];
        int rarity = Integer.parseInt(tokens[1]);

        PlantSpecs plantSpecs = new PlantSpecs(); plantSpecs.rarity = rarity; plantSpecs.grades = new ArrayList<>();
        plantList.put(name, plantSpecs);
    }
    private static void updateGrades (String[] commands, LinkedHashMap<String, PlantSpecs> plantList) {
        String[] tokens = commands[1].split("\\s*-\\s*");

        String name = tokens[0];

        switch (commands[0]) {
            case "Rate":
                if (plantList.containsKey(name)) {
                    plantList.get(name).grades.add(Double.parseDouble(tokens[1]));
                } else {
                    System.out.println("error");
                }
                break;
            case "Update":
                if (plantList.containsKey(name)) {
                    plantList.get(name).rarity = Integer.parseInt(tokens[1]);
                } else {
                    System.out.println("error");
                }
                break;
            case "Reset":
                if (plantList.containsKey(name)) {
                    plantList.get(name).grades.clear();
                } else {
                    System.out.println("error");
                }
                break;
            default:
                System.out.println("error");
        }
    }
    private static void printResult (LinkedHashMap<String, PlantSpecs> plantList) {
        System.out.println("Plants for the exhibition:");
        plantList.forEach((key1, value) -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                key1, value.rarity, value.getAverageGrade(value.grades)));
    }
    public static class PlantSpecs {
        int rarity;
        List<Double> grades;

        public double getAverageGrade(List<Double> grades) {
            int size = grades.size();
            double sum = grades.stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
            if (grades.isEmpty()) {
                return 0.0;
            } else {
                return sum / size;
            }
        }
    }
}