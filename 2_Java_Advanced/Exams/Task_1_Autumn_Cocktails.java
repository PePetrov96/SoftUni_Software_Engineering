import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Task_1_Autumn_Cocktails {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayDeque<Integer> ingredients;
    static Stack<Integer> freshness;
    static int pearSour;
    static int theHarvest;
    static int appleHinny;
    static int highFashion;

    public static void main(String[] args) throws IOException {
        initialize();

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            mixDrinks();
        }

        printResult();
    }
    private static void printResult() {
        if (pearSour > 0 && theHarvest > 0 && appleHinny > 0 && highFashion > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int sum = 0;
            while (!ingredients.isEmpty()) {
                sum += ingredients.pop();
            }
            if (sum != 0) {
                System.out.println("Ingredients left: " + sum);
            }
        }
        if (appleHinny > 0) {
            System.out.println("# Apple Hinny --> " + appleHinny);
        }
        if (highFashion > 0) {
            System.out.println("# High Fashion --> " + highFashion);
        }

        if (pearSour > 0) {
            System.out.println("# Pear Sour --> " + pearSour);
        }

        if (theHarvest > 0) {
            System.out.println("# The Harvest --> " + theHarvest);
        }

    }

    private static void mixDrinks() {
        int ingredient = ingredients.pop();
        if (ingredient == 0) {
            return;
        }

        int currFresh = freshness.pop();

        int totalFreshness = ingredient * currFresh;

        switch (totalFreshness) {
            case 150: pearSour++; break;
            case 250: theHarvest++; break;
            case 300: appleHinny++; break;
            case 400: highFashion++; break;
            default: ingredients.add(ingredient + 5);
        }
    }
    private static void initialize() throws IOException {
        ingredients = Arrays.stream(reader.readLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        freshness = Arrays.stream(reader.readLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));
    }
}