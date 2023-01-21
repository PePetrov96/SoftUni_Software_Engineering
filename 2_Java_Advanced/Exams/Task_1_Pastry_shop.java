import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class Task_1_Pastry_shop {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayDeque<Integer> liquids;
    static Stack<Integer> ingredients;
    static byte biscuit;
    static byte cake;
    static byte pastry;
    static byte pie;

    public static void main(String[] args) throws IOException {
        initialize();

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            mix();
        }

        printResult();
    }

    private static void printResult() {
        System.out.println(biscuit > 0 && cake > 0 && pie > 0 && pastry > 0 ?
                "Great! You succeeded in cooking all the food!" :
                "What a pity! You didn't have enough materials to cook everything.");

        System.out.println(liquids.isEmpty() ?
                "Liquids left: none" :
                "Liquids left: " + String.join(", ", liquids.toString().replaceAll("[\\[\\]]", "")));

        Collections.reverse(ingredients);

        System.out.println(ingredients.isEmpty() ?
                "Ingredients left: none" :
                "Ingredients left: " + String.join(", ", ingredients.toString().replaceAll("[\\[\\]]", "")));

        System.out.printf(
                "Biscuit: %d%n" +
                "Cake: %d%n" +
                "Pie: %d%n" +
                "Pastry: %d%n", biscuit, cake, pie, pastry);
    }
    private static void mix() {
        int liquid = liquids.pop();
        int ingredient = ingredients.pop();

        int sum = liquid + ingredient;

        switch (sum) {
            case 25: biscuit++; break;
            case 50: cake++; break;
            case 75: pastry++; break;
            case 100: pie++; break;
            default: ingredients.add(ingredient + 3);
        }
    }
    private static void initialize() throws IOException {
        liquids = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ingredients = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));
    }
}