import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3_Need_for_Speed_III {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Specs> carList = new LinkedHashMap<>();

        String input = scan.nextLine();

        for (int i = 0; i < Integer.parseInt(input); i++) {
            addCar(carList, scan.nextLine().split("\\|"));
        }

        while (!"Stop".equals(input = scan.nextLine())) {
            modifyCars(carList, input.split("\\s*:\\s*"));
        }

        carList.forEach((key1, value) -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", key1, value.mileage, value.fuel));
    }
    private static void addCar (Map<String, Specs> carList, String[] tokens) {
        Specs specs = new Specs(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
        carList.put(tokens[0], specs);
    }
    private static void modifyCars (Map<String, Specs> carList, String[] input) {
        switch (input[0]) {
            case "Drive": drive(carList, input[1], Integer.parseInt(input[2]), Integer.parseInt(input[3])); break;
            case "Refuel": refuel(carList, input[1], Integer.parseInt(input[2])); break;
            case "Revert": revert(carList, input[1], Integer.parseInt(input[2])); break;
        }
    }
    private static void drive (Map<String, Specs> carList, String car, int distance, int fuel) {
        if (carList.get(car).fuel < fuel) {
            System.out.println("Not enough fuel to make that ride");
        } else {
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
            carList.get(car).fuel -= fuel;
            carList.get(car).mileage += distance;
        }
        if (carList.get(car).mileage >= 100000) {
            System.out.printf("Time to sell the %s!%n", car);
            carList.remove(car);
        }
    }
    private static void refuel (Map<String, Specs> carList, String car, int fuel) {
        if (carList.get(car).fuel + fuel > 75) {
            fuel = 75 - carList.get(car).fuel;
        }
        System.out.printf("%s refueled with %d liters%n", car, fuel);
        carList.get(car).fuel += fuel;
    }
    private static void revert (Map<String, Specs> carList, String car, int kilometers) {
        if (carList.get(car).mileage - kilometers < 10000) {
            carList.get(car).mileage = 10000;
        } else {
            System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
            carList.get(car).mileage -= kilometers;
        }
    }
    private static class Specs {
        int mileage;
        int fuel;

        public Specs(int mileage, int fuel) {
            this.mileage = mileage;
            this.fuel = fuel;
        }
    }
}