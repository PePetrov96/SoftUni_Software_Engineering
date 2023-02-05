import java.util.Scanner;

public class Task_3_Recursive_Fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = {0, 1};
        int finalN = 0;
        for (int i = 0; i < n - 1; i++) {
            finalN = numbers[0] + numbers[1];
            numbers[0] = numbers[1];
            numbers[1] = finalN;
        }
        System.out.println(finalN);
    }
}