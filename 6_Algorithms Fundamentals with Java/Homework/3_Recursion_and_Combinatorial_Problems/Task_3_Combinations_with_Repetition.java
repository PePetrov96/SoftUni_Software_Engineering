import java.util.Scanner;

public class Task_3_Combinations_with_Repetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        generateCombinations(n, k, new int[k], 0, 1);
    }

    public static void generateCombinations(int n, int k, int[] combination, int index, int start) {
        if (index == k) {
            printCombination(combination);
            return;
        }

        for (int i = start; i <= n; i++) {
            combination[index] = i;
            generateCombinations(n, k, combination, index + 1, i);
        }
    }

    public static void printCombination(int[] combination) {
        StringBuilder sb = new StringBuilder();
        for (int i : combination) {
            sb.append(i).append(' ');
        }
        sb.setLength(sb.length() - 1); // Remove trailing space
        System.out.println(sb);
    }
}