package Task_1_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s");

        double fuel = Double.parseDouble(input[1]);
        double consumption = Double.parseDouble(input[2]);
        Vehicle car = new Car(fuel, consumption);

        input = reader.readLine().split("\\s");

        fuel = Double.parseDouble(input[1]);
        consumption = Double.parseDouble(input[2]);
        Vehicle truck = new Truck(fuel, consumption);

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            input = reader.readLine().split("\\s+");

            double unit = Double.parseDouble(input[2]);

            switch (input[0]) {
                case "Drive":
                    if (input[1].equals("Car")) {
                        car.drive(unit);
                    } else {
                        truck.drive(unit);
                    }
                    break;
                case "Refuel":
                    if (input[1].equals("Car")) {
                    car.refuel(unit);
                } else {
                    truck.refuel(unit);
                }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}