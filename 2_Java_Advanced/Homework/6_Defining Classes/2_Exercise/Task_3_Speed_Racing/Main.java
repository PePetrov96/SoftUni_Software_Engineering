import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Car> carList = new LinkedHashMap<>();

        String input = reader.readLine();

        for (int cycles = 0; cycles < Integer.parseInt(input); cycles++) {
            addCar(carList, reader.readLine().split("\\s+"));
        }

        while (!"End".equals(input = reader.readLine())) {
            driveCar(carList, input.split("\\s+"));
        }

        carList.forEach((key, value) -> System.out.println(value));
    }
    private static void driveCar (LinkedHashMap<String, Car> carList, String[] input) {
        if (!input[0].equals("Drive")) { return; }

        String car = input[1];
        int distance = Integer.parseInt(input[2]);

        if (carList.get(car).itCanMove(distance)) {
            carList.get(car).driveIt(distance);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
    private static void addCar (LinkedHashMap<String, Car> carList, String[] input) {
        String carName = input[0];
        double fuelTank = Double.parseDouble(input[1]);
        double fuelPerKm = Double.parseDouble(input[2]);

        Car newCar = new Car(carName, fuelTank, fuelPerKm);

        carList.putIfAbsent(carName, newCar);
    }
}