import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class Task_1_Cooking {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayDeque<Integer> liquids;
    static Stack<Integer> ingredients;
    static int bread;
    static int cake;
    static int pastry;
    static int fruit_Pie;

    public static void main(String[] args) throws IOException {
        initialize();

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            mixFood();
        }

        printResult();
    }

    private static void printResult(){
        if (bread > 0 && cake > 0 && pastry > 0 && fruit_Pie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!" );
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("[\\[\\]]",""));
        }

        Collections.reverse(ingredients);

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("[\\[\\]]",""));
        }

        System.out.printf(
                "Bread: %d%n"+
                "Cake: %d%n"+
                "Fruit Pie: %d%n"+
                "Pastry: %d", bread, cake, fruit_Pie, pastry);
    }

    private static void mixFood(){
        int liquid = liquids.pop();
        int ingredient = ingredients.pop();

        int sum = liquid + ingredient;

        switch (sum) {
            case 25: bread++;
                break;
            case 50: cake++;
                break;
            case 75: pastry++;
                break;
            case 100: fruit_Pie++;
                break;
            default:
                ingredients.push(ingredient+3);
        }
    }
    private static void initialize() throws IOException {
        liquids = Arrays.stream(reader.readLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ingredients = Arrays.stream(reader.readLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));
    }
}