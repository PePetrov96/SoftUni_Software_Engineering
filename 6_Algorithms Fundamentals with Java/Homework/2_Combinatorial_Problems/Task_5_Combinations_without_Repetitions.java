import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_5_Combinations_without_Repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = scanner.nextLine().split("\\s+");

        int k = scanner.nextInt();

        List<List<String>> combinations = findCombinations(elements, k);

        for (List<String> combination : combinations) {
            System.out.println(String.join(" ", combination));
        }
    }

    public static List<List<String>> findCombinations(String[] elements, int k) {
        List<List<String>> combinations = new ArrayList<>();
        generateCombinations(elements, k, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinations(String[] elements, int k, int start, List<String> currentCombination,
                                             List<List<String>> combinations) {
        if (currentCombination.size() == k) {
            combinations.add(new ArrayList<>(currentCombination));
        } else {
            for (int i = start; i < elements.length; i++) {
                currentCombination.add(elements[i]);
                generateCombinations(elements, k, i + 1, currentCombination, combinations);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}