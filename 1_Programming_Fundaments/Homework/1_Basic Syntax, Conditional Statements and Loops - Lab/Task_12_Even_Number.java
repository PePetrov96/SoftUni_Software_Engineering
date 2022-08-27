import java.util.Scanner;

public class Task_12_Even_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int n = Integer.parseInt(scan.nextLine());
            if (n % 2 != 0) {
                System.out.println("Please write an even number.");
            } else {
                System.out.println("The number is: " + Math.abs(n));
                break;
            }
        }
    }
}