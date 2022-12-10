import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task_1_Parking_Lot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> parkingLot = new LinkedHashSet<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {

            String[] commands = input.split(",\\s+");
            switch (commands[0]) {
                case "IN": parkingLot.add(commands[1]); break;
                case "OUT": parkingLot.remove(commands[1]); break;
            }
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}