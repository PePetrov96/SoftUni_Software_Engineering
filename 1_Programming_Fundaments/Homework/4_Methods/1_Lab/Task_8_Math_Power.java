import java.text.DecimalFormat;
import java.util.Scanner;

public class Task_8_Math_Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = toThePowerOf(Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()));

        System.out.println(new DecimalFormat("0.####").format(result));
    }
    private static double toThePowerOf(double number, double power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        return result;
    }
}