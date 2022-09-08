import java.util.Scanner;

public class Task_5_Add_and_Subtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        int num3 = Integer.parseInt(scan.nextLine());
        System.out.println(SumSubtract(SumAdd(num1, num2), num3));
    }
    public static int SumAdd (int num1, int num2) {
        return num1 + num2;
    }
    public static int SumSubtract (int num, int num3) {
        return num - num3;
    }
}