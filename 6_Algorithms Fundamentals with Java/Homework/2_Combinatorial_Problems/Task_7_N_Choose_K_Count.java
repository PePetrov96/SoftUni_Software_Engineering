import java.util.Scanner;

public class Task_7_N_Choose_K_Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long combinations = calculateCombinations(n, k);

        System.out.println(combinations);
    }

    public static long calculateCombinations(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        } else {
            long numerator = 1;
            long denominator = 1;

            for (int i = 1; i <= k; i++) {
                numerator *= n - i + 1;
                denominator *= i;
            }

            return numerator / denominator;
        }
    }
}
