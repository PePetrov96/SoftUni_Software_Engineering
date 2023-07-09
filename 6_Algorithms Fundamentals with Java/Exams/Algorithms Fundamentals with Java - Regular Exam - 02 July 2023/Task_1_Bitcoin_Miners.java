import java.util.Scanner;

public class Task_1_Bitcoin_Miners {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Read the number of transactions in the pool

        int x = scanner.nextInt(); // Read the number of transactions to be selected

        // Print the result
        System.out.println(calculateCombinations(n, x));
    }

    // Function to calculate the binomial coefficient C(n, x)
    private static int calculateCombinations(int n, int x) {
        int[][] dp = new int[n + 1][x + 1];

        // Calculate the number of ways to select x transactions from the pool

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, x); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][x];
    }
}
