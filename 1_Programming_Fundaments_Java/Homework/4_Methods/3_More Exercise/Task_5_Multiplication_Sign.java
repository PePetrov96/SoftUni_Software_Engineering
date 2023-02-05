import java.util.Scanner;

public class Task_5_Multiplication_Sign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        if (isZero(num1, num2, num3)) {
            System.out.println("zero");
        } else if (isNegative(num1, num2, num3)) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
    }
    private static boolean isNegative(int n1, int n2, int n3) {
        int count = 0;
        int[] check = {n1, n2, n3};
        for (int j : check) {
            if (j < 0) {
                count++;
            }
        }

        boolean isNegative = false;
        if (count == 2) {
            isNegative = false;
        } else if (count == 1 || count == 3) {
            isNegative = true;
        }

        return isNegative;
    }
    private static boolean isZero(int n1, int n2, int n3) {
        return n1 == 0.0 || n2 == 0.0 || n3 == 0.0;
    }
}