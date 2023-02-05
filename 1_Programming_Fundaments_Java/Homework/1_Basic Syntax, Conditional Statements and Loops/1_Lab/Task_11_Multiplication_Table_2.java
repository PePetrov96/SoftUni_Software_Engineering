import java.util.Scanner;

public class Task_11_Multiplication_Table_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int multiplier = Integer.parseInt(scan.nextLine());

        do {
            System.out.println(n + " X " + multiplier + " = " + (n * multiplier));
            multiplier++;
        } while (multiplier <= 10);
    }
}