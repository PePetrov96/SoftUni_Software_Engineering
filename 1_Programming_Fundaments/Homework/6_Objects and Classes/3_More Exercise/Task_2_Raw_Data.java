import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_Raw_Data {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        List<Car> carList = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            addCar(input, carList);
        }
        String command = scan.nextLine();
        output(carList, command);
    }
    public static void output (List<Car> carList, String command) {
        if (command.equals("fragile")) {
            carList.stream().
                    filter(car -> (car.cargo.cargoType.equals("fragile") && car.tiers.tire1Pressure < 1 || car.tiers.tire2Pressure < 1 ||
                            car.tiers.tire3Pressure < 1 || car.tiers.tire4Pressure < 1)).forEach(System.out::println);
        } else if (command.equals("flamable")) {
            carList.stream().filter(car -> (car.cargo.cargoType.equals("flamable") && car.engine.enginePower > 250)).forEach(System.out::println);
        }
    }
    public static void addCar (String[] input, List<Car> carList) {
        Engine engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        Cargo cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
        Tiers tiers = new Tiers(Double.parseDouble(input[5]), Integer.parseInt(input[6]),
                Double.parseDouble(input[7]), Integer.parseInt(input[8]),
                Double.parseDouble(input[9]), Integer.parseInt(input[10]),
                Double.parseDouble(input[11]), Integer.parseInt(input[12]));
        Car car = new Car(input[0], engine, cargo, tiers);
        carList.add(car);
    }
    public static class Car {
        public Car(String name, Engine engine, Cargo cargo, Tiers tiers) {
            this.name = name;
            this.engine = engine;
            this.cargo = cargo;
            this.tiers = tiers;
        }
        String name;
        Engine engine;
        Cargo cargo;
        Tiers tiers;

        @Override
        public String toString() {
            return String.format(name);
        }
    }
    public static class Engine {
        public Engine(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }
        int engineSpeed;
        int enginePower;
    }
    public static class Cargo {
        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }
        int cargoWeight;
        String cargoType;
    }
    public static class Tiers {
        public Tiers(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
            this.tire1Pressure = tire1Pressure;
            this.tire1Age = tire1Age;
            this.tire2Pressure = tire2Pressure;
            this.tire2Age = tire2Age;
            this.tire3Pressure = tire3Pressure;
            this.tire3Age = tire3Age;
            this.tire4Pressure = tire4Pressure;
            this.tire4Age = tire4Age;
        }
        double tire1Pressure;
        int tire1Age;
        double tire2Pressure;
        int tire2Age;
        double tire3Pressure;
        int tire3Age;
        double tire4Pressure;
        int tire4Age;
    }
}