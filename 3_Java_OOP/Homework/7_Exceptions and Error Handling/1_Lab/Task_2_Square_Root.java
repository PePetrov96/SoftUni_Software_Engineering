import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task_2_Square_Root {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int num = Integer.parseInt(reader.readLine());
            double squareRoot = Math.sqrt(num);

            if (Double.isNaN(squareRoot)) { throw new ArithmeticException(); }

            System.out.printf("%.2f%n", squareRoot);
        } catch (Exception e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }
}