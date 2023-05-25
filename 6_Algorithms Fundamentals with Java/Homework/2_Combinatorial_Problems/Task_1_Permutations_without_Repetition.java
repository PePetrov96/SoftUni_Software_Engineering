import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_1_Permutations_without_Repetition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");

        print(findPermutations(elements));
    }

    public static List<List<String>> findPermutations(String[] elements) {
        List<List<String>> permutations = new ArrayList<>();
        permute(elements, 0, permutations);
        return permutations;
    }

    private static void permute(String[] elements, int start, List<List<String>> permutations) {
        if (start == elements.length - 1) {
            List<String> permutation = new ArrayList<>(Arrays.asList(elements));
            permutations.add(permutation);
        } else {
            for (int i = start; i < elements.length; i++) {
                swap(elements, start, i);
                permute(elements, start + 1, permutations);
                swap(elements, start, i);
            }
        }
    }

    private static void swap(String[] elements, int i, int j) {
        String temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    private static void print(List<List<String>> permutations) {
        for (List<String> permutation : permutations) {
            System.out.println(String.join(" ", permutation));
        }
    }
}