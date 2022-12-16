import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Car> carList = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {
            addCar(carList, reader.readLine().split("\\s+"));
        }

        printResult(carList, reader.readLine());
    }
    public static void printResult (LinkedHashMap<String, Car> carList, String type) {
        switch (type) {
            case "fragile": carList
                        .entrySet()
                        .stream()
                        .filter(car -> car.getValue().printFragile())
                        .forEach(key -> System.out.println(key.getKey()));
                break;
            case "flamable": carList
                        .entrySet()
                        .stream()
                        .filter(car -> car.getValue().printFlammable())
                        .forEach(key -> System.out.println(key.getKey()));
                break;
        }
    }
    public static void addCar(LinkedHashMap<String, Car> carList, String[] input) {
        String carModel = input[0];
        int engineSpeed = Integer.parseInt(input[1]);
        int enginePower = Integer.parseInt(input[2]);
        int cargoWeight = Integer.parseInt(input[3]);
        String cargoType = input[4];
        double tire1Pressure = Double.parseDouble(input[5]);
        int tire1Age = Integer.parseInt(input[6]);
        double tire2Pressure = Double.parseDouble(input[7]);
        int tire2Age = Integer.parseInt(input[8]);
        double tire3Pressure = Double.parseDouble(input[9]);
        int tire3Age = Integer.parseInt(input[10]);
        double tire4Pressure = Double.parseDouble(input[11]);
        int tire4Age = Integer.parseInt(input[12]);

        Engine engine = new Engine(engineSpeed, enginePower);

        Cargo cargo = new Cargo(cargoWeight, cargoType);

        Tier tier = new Tier(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

        Car car = new Car(carModel, engine, cargo, tier);

        carList.put(carModel, car);
    }
}