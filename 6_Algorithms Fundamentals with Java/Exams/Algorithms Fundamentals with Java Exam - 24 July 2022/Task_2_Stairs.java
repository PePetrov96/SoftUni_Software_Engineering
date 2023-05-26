import java.util.Scanner;

public class Task_2_Stairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long ways = countWaysToClimbStairs(n);
        System.out.println(ways);

        scanner.close();
    }

    private static long countWaysToClimbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
