import java.util.Scanner;

public class Task_2_Print_Numbers_in_Reverse_Order {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(scan.nextLine());
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.print((arr[i]) + " ");
        }
    }
}