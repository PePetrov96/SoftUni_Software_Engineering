import java.util.Scanner;

public class Task_10_Multiplication_Table {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " X " + i + " = " + (i * n));
        }
    }
}