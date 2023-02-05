import java.util.Scanner;

public class Task_4_Sum_of_Chars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sumOfCharacters = 0;

        for (int i = 1; i <= n; i++) {
            char character = scan.nextLine().charAt(0);
            sumOfCharacters += character;
        }
        System.out.println("The sum equals: " + sumOfCharacters);
    }
}