import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task_1_Bouquets {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayDeque<Integer> daffodils;
    static ArrayDeque<Integer> tulips;
    static int bouquets;
    static int remainder;

    public static void main(String[] args) throws IOException {
        initialize();

        combine();

        printResult();
    }
    private static void combine() {
        while (!daffodils.isEmpty() && !tulips.isEmpty()) {

            int daffodil = daffodils.pop();
            int tulip = tulips.remove();

            int sum = (daffodil + tulip);

            if (sum == 15) {
                bouquets++;
            } else if (sum > 15) {
                tulips.add(tulip - 2);
                daffodils.push(daffodil);
            } else {
                remainder += sum;
            }
        }

        bouquets += (remainder / 15);
    }

    private static void printResult() {
        if (bouquets < 5) {
            System.out.printf("You failed... You need more %d bouquets.", (5 - bouquets));
        } else {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        }
    }
    private static void initialize() throws IOException {
        daffodils = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        tulips = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}