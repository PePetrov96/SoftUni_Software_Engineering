import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {
            String[] input = reader.readLine().split("\\s+");

            Car car = new Car();

            car.setBrand(input[0]);
            car.setModel(input[1]);
            car.setHorsePower(Integer.parseInt(input[2]));

            System.out.println(car.carInfo());
        }
    }
}