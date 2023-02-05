import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3_Car_Salesman {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Engine> engineList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] engineInput = scan.nextLine().split("\\s+");
            addEngine(engineList, engineInput);
        }

        List<Car> carList = new ArrayList<>();
        int m = Integer.parseInt(scan.nextLine());
        while (m-- > 0) {
            String[] carInput = scan.nextLine().split("\\s+");
            addCar(carList, carInput, engineList);
        }

        carList.forEach(System.out::println);
    }
    public static void addCar (List<Car> carList, String[] input, List<Engine> engineList) {
        Car car = new Car();
        Engine engine1 = new Engine();

        car.carModel = input[0];
        for (Engine engine : engineList) {
            if (engine.engineModel.equals(input[1])) {
                engine1.engineModel = input[1];
                engine1.power = engine.getPower();
                engine1.displacement = engine.getDisplacement();
                engine1.efficiency = engine.getEfficiency();
                break;
            }
        }
        car.engine = engine1;

        if (input.length == 3) {
            try {
                int temp = Integer.parseInt(input[2]);
                car.weight = String.valueOf(temp);
            } catch (NumberFormatException e) {
                car.color = input[2];
            }
        } else if (input.length == 4) {
            car.weight = input[2];
            car.color = input[3];
        }
        carList.add(car);
    }
    public static void addEngine (List<Engine> engineList, String[] input) {
        Engine engine = new Engine();
        engine.engineModel = input[0]; engine.power = Integer.parseInt(input[1]);
        if (input.length == 3) {
            try {
                int temp = Integer.parseInt(input[2]);
                engine.displacement = String.valueOf(temp);
            } catch (NumberFormatException e) {
                engine.efficiency = input[2];
            }
        } else if (input.length == 4) {
            engine.displacement = input[2];
            engine.efficiency = input[3];
        }
        engineList.add(engine);
    }
    public static class Car {
        public Car() {
            this.weight = "n/a";
            this.color = "n/a";
        }
        String carModel;
        Engine engine;
        String weight;
        String color;

        @Override
        public String toString() {
            return String.format(
                    "%s:%n" +
                    " %s:%n" +
                    "  Power: %d%n" +
                    "  Displacement: %s%n" +
                    "  Efficiency: %s%n" +
                    " Weight: %s%n" +
                    " Color: %s", carModel, engine.engineModel, engine.power,
                    engine.displacement, engine.efficiency, weight, color);
        }
    }
    public static class Engine {
        public Engine() {
            this.displacement = "n/a";
            this.efficiency = "n/a";
        }
        String engineModel;
        int power;
        String displacement;
        String efficiency;

        public int getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }
    }
}