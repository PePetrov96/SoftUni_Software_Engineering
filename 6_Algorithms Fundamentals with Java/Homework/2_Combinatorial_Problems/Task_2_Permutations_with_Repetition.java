import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task_2_Permutations_with_Repetition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().split("\\s+");

        print(findPermutations(elements));
    }

    public static List<List<String>> findPermutations(String[] elements) {
        List<List<String>> permutations = new ArrayList<>();
        Map<String, Integer> frequencyMap = buildFrequencyMap(elements);
        permute(frequencyMap, new ArrayList<>(), elements.length, permutations);
        return permutations;
    }

    private static void permute(Map<String, Integer> frequencyMap, List<String> currentPermutation,
                                int remaining, List<List<String>> permutations) {
        if (remaining == 0) {
            permutations.add(new ArrayList<>(currentPermutation));
        } else {
            for (String element : frequencyMap.keySet()) {
                int frequency = frequencyMap.get(element);
                if (frequency > 0) {
                    currentPermutation.add(element);
                    frequencyMap.put(element, frequency - 1);
                    permute(frequencyMap, currentPermutation, remaining - 1, permutations);
                    frequencyMap.put(element, frequency);
                    currentPermutation.remove(currentPermutation.size() - 1);
                }
            }
        }
    }

    private static Map<String, Integer> buildFrequencyMap(String[] elements) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : elements) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }
    private static void print(List<List<String>> permutations) {
        for (List<String> permutation : permutations) {
            System.out.println(String.join(" ", permutation));
        }
    }
}
