import java.util.Scanner;

public class Task_1_Sign_of_Integer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printSign(Integer.parseInt(scan.nextLine()));
    }
    public static void printSign(int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else {
            System.out.printf("The number %d is zero.", number);
        }
    }
}
