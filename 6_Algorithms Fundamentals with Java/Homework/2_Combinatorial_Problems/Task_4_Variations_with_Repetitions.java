import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_4_Variations_with_Repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\s+");
        int k = scanner.nextInt();

        print(findVariations(elements, k));
    }

    public static List<List<String>> findVariations(String[] elements, int k) {
        List<List<String>> variations = new ArrayList<>();
        generateVariations(elements, k, new ArrayList<>(), variations);
        return variations;
    }

    private static void generateVariations(String[] elements, int k, List<String> currentVariation,
                                           List<List<String>> variations) {
        if (currentVariation.size() == k) {
            variations.add(new ArrayList<>(currentVariation));
        } else {
            for (String element : elements) {
                currentVariation.add(element);
                generateVariations(elements, k, currentVariation, variations);
                currentVariation.remove(currentVariation.size() - 1);
            }
        }
    }
    private static void print(List<List<String>> variations) {
        for (List<String> variation : variations) {
            System.out.println(String.join(" ", variation));
        }
    }
}