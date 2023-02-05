import java.util.Scanner;

public class Task_3_Passed_or_Failed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (scan.nextDouble() >= 3.00) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
