import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_7_Recursive_Fibonacci {
    private static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        memo = new long[n + 1];
        System.out.println(getFibonacci(n));
    }

    public static long getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        return memo[n];
    }
}