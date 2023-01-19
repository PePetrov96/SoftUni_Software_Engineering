import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Task_1_Energy_Drinks {
    static Stack<Integer> caffeineSequence;
    static ArrayDeque<Integer> drinksSequence;
    static int caffeineConsumed = 0;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        initializeStacks();

        while (!caffeineSequence.isEmpty()
                && !drinksSequence.isEmpty()) {
            getDrink();
        }

        printResult();
    }
    private static void getDrink() {
        int thisDrink = caffeineSequence.peek() * drinksSequence.peek();

        if (thisDrink + caffeineConsumed <= 300) {
            caffeineConsumed += (caffeineSequence.pop() * drinksSequence.remove());
        } else {
            caffeineSequence.pop();
            drinksSequence.add(drinksSequence.remove());
            caffeineConsumed = Math.max(caffeineConsumed -= 30, 0);
        }

    }
    private static void printResult() {
        System.out.println(drinksSequence.isEmpty() ?
                "At least Stamat wasn't exceeding the maximum caffeine." :
                "Drinks left: " + drinksSequence.toString().replaceAll("[\\[\\]]",""));

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeineConsumed);
    }

    private static void initializeStacks() throws IOException {
        caffeineSequence = Arrays.stream(reader.readLine().trim().split(",\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));

        drinksSequence = Arrays.stream(reader.readLine().trim().split(",\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}