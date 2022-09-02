import java.util.Scanner;

public class Task_1_Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] passengerArr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            passengerArr[i] = Integer.parseInt(scan.nextLine());
            sum += passengerArr[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(passengerArr[i] + " ");
        }
        System.out.println("\n" + sum);
    }
}