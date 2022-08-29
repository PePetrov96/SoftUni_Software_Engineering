import java.util.Scanner;

public class Task_7_Reversed_Chars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);
        char thirdChar = scan.nextLine().charAt(0);
        System.out.printf("%c %c %c", thirdChar, secondChar, firstChar);
    }
}