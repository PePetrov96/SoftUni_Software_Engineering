import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_3_Bitcoin_Transactions {
    private static String[] array1;
    private static String[] array2;
    private static int[][] dp;

    public static void main(String[] args) {
        // Read from the console and fill in the arrays
        initialize();

        // Compute the lengths of the common subsequences using dynamic programming
        computeLengths();

        // Backtrack through the matrix to find the transaction IDs of the longest common subsequence
        List<String> sequence = findLongestSequence();

        // Print the result
        printResult(sequence);
    }

    private static void initialize() {
        Scanner scanner = new Scanner(System.in);

        // Read the input arrays of Bitcoin transactions
        array1 = scanner.nextLine().split("\\s");
        array2 = scanner.nextLine().split("\\s");

        // Initialize a 2D matrix to store the lengths of the common subsequences
        dp = new int[array1.length + 1][array2.length + 1];
    }

    private static void computeLengths() {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
    }

    private static List<String> findLongestSequence() {
        List<String> sequence = new ArrayList<>();

        int i = array1.length;
        int j = array2.length;

        while (i > 0 && j > 0) {
            if (array1[i - 1].equals(array2[j - 1])) {
                sequence.add(array1[i - 1]);
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }
        return sequence;
    }

    private static void printResult(List<String> sequence) {
        // Reverse the sequence to get the correct order of transaction IDs
        Collections.reverse(sequence);

        // Print the sequence
        System.out.println(sequence.toString().replaceAll(",",""));
    }
}
