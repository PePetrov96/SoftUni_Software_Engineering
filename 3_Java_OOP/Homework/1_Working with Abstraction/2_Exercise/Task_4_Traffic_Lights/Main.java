import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<TrafficLight.Color> lights = new ArrayList<>();

        String[] input = reader.readLine().split("\\s+");

        for (String s : input) {
            lights.add(TrafficLight.Color.valueOf(s));
        }

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            lights = TrafficLight.update(lights);
            System.out.println(lights.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}