import java.util.Scanner;

public class Task_10_Top_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            if (hasOddDigit(i) && isDivisibleBy8(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean hasOddDigit (int n) {
        boolean hasOddDigit = false;
        String length = String.valueOf(n);
        for (int i = 0; i < length.length(); i++) {
            if ((n % 10) % 2 != 0) {
                hasOddDigit = true;
                break;
            } else {
                n /= 10;
            }
        }
        return hasOddDigit;
    }
    public static boolean isDivisibleBy8 (int n) {
        boolean isDivisible = false;
        int sum = 0;
        String length = String.valueOf(n);
        for (int i = 0; i < length.length(); i++) {
            sum += (n % 10);
            n /= 10;
        }
        if (sum % 8 == 0) {
            isDivisible = true;
        }
        return isDivisible;
    }
}