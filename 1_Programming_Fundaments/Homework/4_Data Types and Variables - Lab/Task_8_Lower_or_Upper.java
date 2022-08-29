import java.util.Scanner;

public class Task_8_Lower_or_Upper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char character = scan.nextLine().charAt(0);
        if (Character.isLowerCase(character)) {
            System.out.println("lower-case");
        } else {
            System.out.println("upper-case");
        }
    }
}