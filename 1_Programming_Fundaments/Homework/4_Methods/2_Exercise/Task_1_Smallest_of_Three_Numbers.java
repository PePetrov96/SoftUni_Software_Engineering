import java.util.Scanner;

public class Task_1_Smallest_of_Three_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        System.out.println(lowestNumber(num1, num2, num3));
    }
    public static int lowestNumber (int num1, int num2, int num3) {
        int smallestNum;
        if (num1 <= num2 && num1 <= num3) {
            smallestNum = num1;
        } else if (num2 <= num1 && num2 <= num3) {
            smallestNum = num2;
        } else {
            smallestNum = num3;
        }
        return smallestNum;
    }
}