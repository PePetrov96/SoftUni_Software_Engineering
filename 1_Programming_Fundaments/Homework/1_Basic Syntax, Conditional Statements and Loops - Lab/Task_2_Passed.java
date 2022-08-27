import java.util.Scanner;

public class Task_2_Passed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double grade = Double.parseDouble(scan.nextLine());
        if (grade >= 3.00) {
            System.out.println("Passed!");
        }
    }
}
