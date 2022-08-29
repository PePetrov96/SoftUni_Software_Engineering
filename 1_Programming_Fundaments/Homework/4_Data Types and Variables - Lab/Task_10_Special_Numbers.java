import java.util.Scanner;

public class Task_10_Special_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());

        for (int num = 1; num <= number; num++) {
            int sumOfDigits = 0;
            int digit = num;
            while (digit > 0) {
                sumOfDigits += digit % 10;
                digit = digit / 10;
            }
            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.printf("%d -> True%n", num);
            } else {
                System.out.printf("%d -> False%n", num);
            }
        }
    }
}