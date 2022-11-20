import java.util.*;

public class Task_3_Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Cities> citiesList = new LinkedHashMap<>();

        String input;

        while (!"Sail".equals(input = scan.nextLine())) {
            updateEntries(input.split("\\s*\\|\\|\\s*"), citiesList);
        }

        while (!"End".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s*=>\\s*");
            switch (tokens[0]) {
                case "Plunder":
                    plunder(citiesList, tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
                    break;
                case "Prosper":
                    prosper(citiesList, tokens[1], Integer.parseInt(tokens[2]));
                    break;
            }
        }

        printResult(citiesList);
    }
    private static void plunder (Map<String, Cities> citiesList, String name, int population, int gold) {
        if (citiesList.get(name).cityGold <= gold || citiesList.get(name).cityPopulation <= population) {
            if (citiesList.get(name).cityGold - gold < 0) {
                gold = citiesList.get(name).cityGold;
            }
            if (citiesList.get(name).cityPopulation - population < 0) {
                population = citiesList.get(name).cityPopulation;
            }
            System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", name,
                    gold, population);
            System.out.printf("%s has been wiped off the map!%n", name);
            citiesList.remove(name);
        } else {
            citiesList.get(name).cityPopulation -= population;
            citiesList.get(name).cityGold -= gold;
            System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                    name, gold, population);
        }
    }
    private static void prosper (Map<String, Cities> citiesList, String name, int gold) {
        if (gold <= 0) {
            System.out.println("Gold added cannot be a negative number!");
        } else {
            citiesList.get(name).cityGold += gold;
            System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, name, citiesList.get(name).cityGold);
        }
    }
    private static void printResult (Map<String, Cities> citiesList) {
        if (citiesList.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesList.keySet().size());
            citiesList.forEach((key1, value) -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key1, value.cityPopulation, value.cityGold));
        }
    }
    private static void updateEntries (String[] tokens, Map<String, Cities> citiesList) {
        Cities city = new Cities();
        if (!citiesList.containsKey(tokens[0])) {
            city.cityGold = Integer.parseInt(tokens[2]);
            city.cityPopulation = Integer.parseInt(tokens[1]);
        } else {
            city.cityGold = citiesList.get(tokens[0]).cityGold + Integer.parseInt(tokens[2]);
            city.cityPopulation = citiesList.get(tokens[0]).cityPopulation + Integer.parseInt(tokens[1]);
        }
        citiesList.put(tokens[0], city);

    }
    private static class Cities {
        int cityPopulation;
        int cityGold;
    }
}