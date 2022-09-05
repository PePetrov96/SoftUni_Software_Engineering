import java.util.Scanner;

public class Task_2_Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printGrade(Double.parseDouble(scan.nextLine()));
    }
    public static void printGrade(double grade) {
        if (grade<3.00) {
            System.out.println("Fail");
        } else if (grade<3.50) {
            System.out.println("Poor");
        } else if (grade<4.50) {
            System.out.println("Good");
        } else if (grade<5.50) {
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }

    }
}