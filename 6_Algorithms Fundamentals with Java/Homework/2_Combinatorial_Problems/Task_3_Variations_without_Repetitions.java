import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task_3_Variations_without_Repetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");
        int k = Integer.parseInt(reader.readLine());

        print(findVariations(elements, k));
    }
    public static List<List<String>> findVariations(String[] elements, int k) {
        List<List<String>> variations = new ArrayList<>();
        boolean[] used = new boolean[elements.length];
        generateVariations(elements, k, new ArrayList<>(), variations, used);
        return variations;
    }

    private static void generateVariations(String[] elements, int k, List<String> currentVariation,
                                           List<List<String>> variations, boolean[] used) {
        if (currentVariation.size() == k) {
            variations.add(new ArrayList<>(currentVariation));
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    currentVariation.add(elements[i]);
                    generateVariations(elements, k, currentVariation, variations, used);
                    used[i] = false;
                    currentVariation.remove(currentVariation.size() - 1);
                }
            }
        }
    }

    private static void print(List<List<String>> variations) {
        for (List<String> variation : variations) {
            System.out.println(String.join(" ", variation));
        }
    }
}