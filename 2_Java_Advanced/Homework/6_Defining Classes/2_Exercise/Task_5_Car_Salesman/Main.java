import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Engine> enginesList = new HashMap<>();
        List<Car> carsList = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int engineCycles = 0; engineCycles < n; engineCycles++) {
            addEngine(enginesList, reader.readLine().split("\\s+"));
        }

        n = Integer.parseInt(reader.readLine());

        for (int carCycles = 0; carCycles < n; carCycles++) {
            addCar(carsList, enginesList, reader.readLine().split("\\s+"));
        }

        carsList.forEach(System.out::println);
    }
    private static void addEngine(HashMap<String, Engine> enginesList, String[] input) {
        if (enginesList.containsKey(input[0])) { return; }

        String engineModel = input[0];
        int enginePower = Integer.parseInt(input[1]);

        Engine newEngine = new Engine(engineModel, enginePower);
        if (input.length > 2) { addAdditionalEngineDetails(newEngine, input); }

        enginesList.put(engineModel, newEngine);
    }
    private static void addAdditionalEngineDetails (Engine newEngine, String[] input) {
        if (input.length == 4) {
            newEngine.engineDisplacement = input[2];
            newEngine.engineEfficiency = input[3];
        } else if (input.length == 3) {
            try {
                int check = Integer.parseInt(input[2]);
                newEngine.engineDisplacement = String.valueOf(check);
            } catch (NumberFormatException e) {
                newEngine.engineEfficiency = input[2];
            }
        }
    }
    private static void addCar (List<Car> carsList, HashMap<String, Engine> enginesList, String[] input) {
        String carModel = input[0];
        String engineModel = input[1];

        Car newCar = new Car(carModel, enginesList.get(engineModel));

        if (input.length > 2) { addAdditionalCarDetails(newCar, input); }

        carsList.add(newCar);
    }
    private static void addAdditionalCarDetails (Car newCar, String[] input) {
        if (input.length == 4) {
            newCar.weight = input[2];
            newCar.color = input[3];
        } else if (input.length == 3) {
            try {
                int check = Integer.parseInt(input[2]);
                newCar.weight = String.valueOf(check);
            } catch (NumberFormatException e) {
                newCar.color = input[2];
            }
        }
    }
}