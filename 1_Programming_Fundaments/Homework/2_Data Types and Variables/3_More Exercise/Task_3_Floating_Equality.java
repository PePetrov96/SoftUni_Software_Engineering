import java.util.Scanner;

public class Task_3_Floating_Equality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scan.nextLine());
        double secondNumber = Double.parseDouble(scan.nextLine());

        double difference = Math.abs(firstNumber - secondNumber);

        if (difference < 0.000001) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}