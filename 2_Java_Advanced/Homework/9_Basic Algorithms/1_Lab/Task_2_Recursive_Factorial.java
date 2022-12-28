import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_2_Recursive_Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        System.out.println(factorial(num));
    }
    static long factorial(int num) {
        if (num == 1) {
            return num;
        }
        return num * factorial(num - 1);
    }
}