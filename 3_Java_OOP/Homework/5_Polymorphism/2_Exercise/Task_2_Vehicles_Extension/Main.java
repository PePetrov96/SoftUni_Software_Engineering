package Task_2_Vehicles_Extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Vehicle car = createVehicle(bufferedReader);
        Vehicle truck = createVehicle(bufferedReader);
        Bus bus = (Bus) createVehicle(bufferedReader);

        int numberOfCommands = Integer.parseInt(bufferedReader.readLine());

        label:
        for (int i = 0; i < numberOfCommands; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");
            String command = lines[0];
            String vehicleType = lines[1];
            double value = Double.parseDouble(lines[2]);
            try {
                switch (command) {
                    case "Drive":
                        switch (vehicleType) {
                            case "Car": System.out.println(car.drive(value)); break;
                            case "Truck": System.out.println(truck.drive(value)); break;
                            case "Bus": System.out.println(bus.drive(value)); break;
                        }
                        break;
                    case "Refuel":
                        switch (vehicleType) {
                            case "Car": car.refuel(value); break;
                            case "Truck": truck.refuel(value); break;
                            case "Bus": bus.refuel(value); break;
                        }
                        break;
                    case "DriveEmpty":
                        bus.setEmpty(true);
                        System.out.println(bus.drive(value));
                        break;
                    default:
                        break label;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static Vehicle createVehicle(BufferedReader bufferedReader) throws IOException {
        String[] lines = bufferedReader.readLine().split("\\s+");

        String vehicleType = lines[0];
        double fuelQuantity = Double.parseDouble(lines[1]);
        double fuelConsumption = Double.parseDouble(lines[2]);
        double tankCapacity = Double.parseDouble(lines[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            case "Bus":
                return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
            default:
                return null;
        }
    }
}
