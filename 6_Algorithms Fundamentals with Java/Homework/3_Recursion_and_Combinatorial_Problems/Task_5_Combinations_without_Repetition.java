import java.util.Scanner;

public class Task_5_Combinations_without_Repetition {

    private static int[] elements;
    private static int k;
    private static int[] combination;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.close();

        elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i + 1;
        }

        combination = new int[k];
        generateCombinations(0, 0);
    }

    private static void generateCombinations(int startIndex, int currentIndex) {
        if (currentIndex == k) {
            printCombination();
            return;
        }

        for (int i = startIndex; i < elements.length; i++) {
            combination[currentIndex] = elements[i];
            generateCombinations(i + 1, currentIndex + 1);
        }
    }

    private static void printCombination() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < k; i++) {
            out.append(combination[i]).append(" ");
        }
        System.out.println(out.toString().trim());
    }
}