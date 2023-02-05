import java.util.Scanner;

public class Task_7_Water_Overflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int totalFilled = 0;

        for (int i = 0; i < n; i++) {
            int add = Integer.parseInt(scan.nextLine());
            if ((totalFilled + add) <= 255) {
                totalFilled += add;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(totalFilled);
    }
}