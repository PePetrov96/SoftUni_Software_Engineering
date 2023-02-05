import java.util.Scanner;

public class Task_2_ASCII_Sumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(returnString(scan.nextLine(), scan.nextLine(), scan.nextLine()));
    }
    private static int returnString (String startChar, String endChar, String text) {
        int result = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > startChar.charAt(0) && text.charAt(i) < endChar.charAt(0)) {
                result += text.charAt(i);
            }
        }
        return result;
    }
}