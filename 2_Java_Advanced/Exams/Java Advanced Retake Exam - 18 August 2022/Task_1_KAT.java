import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Task_1_KAT {
    static long registered = 0;
    static long days = 0;
    static ArrayDeque<Long> plates;

    static Deque<Long> cars;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        plates = Arrays.stream(reader.readLine().split(",\\s"))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        cars = Arrays.stream(reader.readLine().split(",\\s"))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!plates.isEmpty() && !cars.isEmpty()) {
            registerCars();
        }

        printResult();

    }

    private static void printResult() {
        System.out.printf("%d cars were registered for %d days!%n", registered, days);

        if (!plates.isEmpty()) {
            long remainingPlates = 0;

            while (!plates.isEmpty()) {
                remainingPlates += plates.pop();
            }

            System.out.println(remainingPlates + " license plates remain!");

        } else if (!cars.isEmpty()) {
            long remainingCars = 0;

            while (!cars.isEmpty()) {
                remainingCars += cars.pop();
            }

            System.out.println(remainingCars + " cars remain without license plates!");

        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
    private static void registerCars() {
        long noPlates = plates.remove();
        long noCars = cars.pollLast();

        if (noPlates > (noCars * 2)) {
            plates.add(noPlates - (noCars * 2));
            registered += noCars;

        } else if ((noCars * 2) > noPlates) {
            long leftCars = noCars - (noPlates / 2);
            cars.push(leftCars);

            registered += (noPlates / 2);
        } else {
            registered += noCars;
        }

        days++;
    }
}