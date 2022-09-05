import java.util.Scanner;

public class Task_10_Multiply_Evens_by_Odds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Math.abs(Integer.parseInt(sc.nextLine()));
        System.out.println(getMultipleOfEvenAndOdd(n));
    }
    public static int getSumOfEvenDigits (int n) {
        int evenSum = 0;
        String a = String.valueOf(n);
        int[] number = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            number[i] = Integer.parseInt(String.valueOf(a.charAt(i)));
        }
        for (int i = 0; i < a.length(); i++) {
            if (number[i] % 2 == 0) {
                evenSum += number[i];
            }
        }
        return evenSum;
    }
    public static int getSumOfOddDigits (int n) {
        int oddSum = 0;
        String a = String.valueOf(n);
        int[] number = new int[a.length()];
        for (int i = 0; i < a.length(); i++) {
            number[i] = Integer.parseInt(String.valueOf(a.charAt(i)));
        }
        for (int i = 0; i < a.length(); i++) {
            if (number[i] % 2 != 0) {
                oddSum += number[i];
            }
        }
        return oddSum;
    }
    public static int getMultipleOfEvenAndOdd (int n) {
        int evenSum = getSumOfEvenDigits(n);
        int oddSum = getSumOfOddDigits(n);
        return evenSum * oddSum;
    }
}