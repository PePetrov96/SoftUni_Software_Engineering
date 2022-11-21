import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3_Need_for_Speed_III {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        Map<String, carSpecs> carList = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            addCar(carList, scan.nextLine().split("\\|"));
        }

        String input;
        while (!"Stop".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s*:\\s*");

            switch (tokens[0]) {
                case "Drive": drive(carList, tokens); break;
                case "Refuel": refuel(carList, tokens); break;
                case "Revert": revert(carList, tokens); break;
            }
        }
        if (!carList.isEmpty()) {
            carList.forEach((key, value) -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", key, value.mileage, value.fuel));
        }
    }
    private static void addCar (Map<String, carSpecs> carList, String[] input) {
        carSpecs specs = new carSpecs();
        specs.mileage = Integer.parseInt(input[1]);
        specs.fuel = Integer.parseInt(input[2]);
        carList.putIfAbsent(input[0], specs);
    }
    private static void drive (Map<String, carSpecs> carList, String[] input) {
        String car = input[1];
        int mileage = Integer.parseInt(input[2]);
        int fuel = Integer.parseInt(input[3]);

        if (carList.get(car).fuel < fuel) {
            System.out.println("Not enough fuel to make that ride");
        } else {
            carList.get(car).fuel -= fuel;
            carList.get(car).mileage += mileage;
            System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, mileage, fuel);
        }

        if (carList.get(car).mileage >= 100000) {
            System.out.printf("Time to sell the %s!%n", car);
            carList.remove(car);
        }

    }
    private static void refuel (Map<String, carSpecs> carList, String[] input) {
        String car = input[1]; int fuel = Integer.parseInt(input[2]);

        if (carList.get(car).fuel + fuel > 75) {
            fuel = 75 - carList.get(car).fuel;
        }

        carList.get(car).fuel += fuel;
        System.out.printf("%s refueled with %d liters%n", car, fuel);
    }
    private static void revert (Map<String, carSpecs> carList, String[] input) {
        String car = input[1]; int mileage = Integer.parseInt(input[2]);

        if (carList.get(car).mileage - mileage > 10000) {
            carList.get(car).mileage -= mileage;
            System.out.printf("%s mileage decreased by %d kilometers%n", car, mileage);
        } else {
            carList.get(car).mileage = 10000;
        }
    }
    private static class carSpecs {
        int mileage;
        int fuel;
    }
}