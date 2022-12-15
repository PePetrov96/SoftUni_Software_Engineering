import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Car> carList = new ArrayList<>();

        for (int cycles = 0; cycles < n; cycles++) {
            String[] input = reader.readLine().split("\\s+");

            Car car;

            if (input.length == 1) {
                car = new Car(input[0]);
            } else {
                car = new Car(input[0], input[1], Integer.parseInt(input[2]));
            }

            carList.add(car);

        }

        carList.forEach(car -> System.out.println(car.carInfo()));
    }
}