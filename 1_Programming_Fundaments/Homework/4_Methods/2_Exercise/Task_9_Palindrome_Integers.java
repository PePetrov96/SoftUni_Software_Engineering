import java.util.Scanner;

public class Task_9_Palindrome_Integers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals("END")) {
            if (isPalindrome(input)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = scan.nextLine();
        }

    }
    public static boolean isPalindrome (String n) {
        boolean isPalindrome = true;
        int length = n.length() - 1;
        for (int i = 0; i <= length; i++) {
            if (n.charAt(i) != n.charAt(length - i)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}