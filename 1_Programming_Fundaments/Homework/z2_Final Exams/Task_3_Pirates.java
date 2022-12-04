import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3_Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, City> cityMap = new LinkedHashMap<>();
        String input;

        while (!"Sail".equals(input = scan.nextLine())) {
            String[] commands = input.split("\\|\\|");
            addCity(cityMap, commands[0]
                    ,Integer.parseInt(commands[1])
                    ,Integer.parseInt(commands[2]));
        }

        while (!"End".equals(input = scan.nextLine())) {
            String[] commands = input.split("=>");
            switch (commands[0]) {
                case "Plunder":
                    plunder(cityMap, commands[1], Integer.parseInt(commands[2]), Integer.parseInt(commands[3])); break;
                case "Prosper":
                    prosper(cityMap, commands[1],Integer.parseInt(commands[2])); break;
            }
        }

        printResult(cityMap);
    }
    private static void addCity (Map<String, City> cityMap, String cityName, int population, int gold) {
        if (cityMap.containsKey(cityName)) {
            cityMap.get(cityName).population += population;
            cityMap.get(cityName).gold += gold;
        } else {
            City city = new City(population, gold);
            cityMap.put(cityName, city);
        }
    }
    private static void plunder (Map<String, City> cityMap, String cityName, int population, int gold) {
        if (cityMap.containsKey(cityName)) {
            System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, gold, population);
            cityMap.get(cityName).population -= population;
            cityMap.get(cityName).gold -= gold;
        }
        if (cityMap.get(cityName).population <= 0 || cityMap.get(cityName).gold <= 0) {
            System.out.println(cityName + " has been wiped off the map!");
            cityMap.remove(cityName);
        }
    }
    private static void prosper (Map<String, City> cityMap, String cityName, int gold) {
        if (gold < 0) {
            System.out.println("Gold added cannot be a negative number!");
        } else {
            if (cityMap.containsKey(cityName)) {
                cityMap.get(cityName).gold += gold;
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, cityName, cityMap.get(cityName).gold);
            }
        }

    }
    private static void printResult (Map<String, City> cityMap) {
        if (cityMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityMap.keySet().size());
            cityMap.forEach((key, value) -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key, value.population, value.gold));
        }
    }
    private static class City {
        int population;
        int gold;
        public City(int population, int gold) {
            this.population = population;
            this.gold = gold;
        }
    }
}