import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task_3_Odd_Occurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        countInstances(words, counts);
        printOut(counts);
    }
    private static void countInstances (String[] words, LinkedHashMap<String, Integer> counts) {
        for (String word : words) {
            String wordInLowerCase = word.toLowerCase();
            if (counts.containsKey(wordInLowerCase)) {
                counts.put(wordInLowerCase, counts.get(wordInLowerCase) + 1);
            } else {
                counts.put(wordInLowerCase, 1);
            }
        }
    }
    private static void printOut (LinkedHashMap<String, Integer> counts) {
        ArrayList<String> odds = new ArrayList<>();

        for (var entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odds.add(entry.getKey());
            }
        }

        System.out.println(odds.toString().replaceAll("[\\[\\]]", ""));
    }
}