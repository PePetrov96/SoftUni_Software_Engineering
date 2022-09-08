import java.util.Scanner;

public class Task_8_Factorial_Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1 = Double.parseDouble(scan.nextLine());
        double num2 = Double.parseDouble(scan.nextLine());

        System.out.printf("%.2f", factorialOf(num1) / factorialOf(num2));
    }
    public static double factorialOf (double n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result * (n - i);
        }
        return result;
    }
}