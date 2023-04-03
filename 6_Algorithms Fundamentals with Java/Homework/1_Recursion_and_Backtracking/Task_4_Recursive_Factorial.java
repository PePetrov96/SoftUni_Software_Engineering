import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_4_Recursive_Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(factorial(Integer.parseInt(reader.readLine())));
    }
    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}