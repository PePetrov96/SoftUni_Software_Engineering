import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task_1_Its_Chocolate_Time {
    static int milkChocolate = 0;
    static int darkChocolate = 0;
    static int bakingChocolate = 0;
    static ArrayDeque<Double> milkQuantity;
    static ArrayDeque<Double> cacaoQuantity;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        initialize();

        while (!milkQuantity.isEmpty() && !cacaoQuantity.isEmpty()) {
            getChocolate();
        }

        printResult();
    }
    private static void printResult() {
        boolean isComplete = milkChocolate > 0 && darkChocolate > 0 && bakingChocolate> 0;
        System.out.println(isComplete ?
                "It’s a Chocolate Time. All chocolate types are prepared." :
                "Sorry, but you didn't succeed to prepare all types of chocolates.");

        if (bakingChocolate > 0) {
            System.out.println("# Baking Chocolate --> " + bakingChocolate);
        }

        if (darkChocolate > 0) {
            System.out.println("# Dark Chocolate --> " + darkChocolate);
        }

        if (milkChocolate > 0) {
            System.out.println("# Milk Chocolate --> " + milkChocolate);
        }
    }
    private static void getChocolate() {
        double milk = milkQuantity.pollFirst();
        double cacao = cacaoQuantity.pollLast();

        double cacaoPercentage = (cacao / (milk + cacao)) * 100;

        if (cacaoPercentage == 100.0) {
            bakingChocolate++;
        } else if (cacaoPercentage == 50.0) {
            darkChocolate++;
        } else if (cacaoPercentage == 30.0) {
            milkChocolate++;
        } else {
            milkQuantity.add(milk + 10);
        }
    }
    private static void initialize() throws IOException {
        milkQuantity = Arrays.stream(reader.readLine().split("\\s"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        cacaoQuantity = Arrays.stream(reader.readLine().split("\\s"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}