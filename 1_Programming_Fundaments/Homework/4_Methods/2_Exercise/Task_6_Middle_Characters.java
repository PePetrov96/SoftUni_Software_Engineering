import java.util.Scanner;

public class Task_6_Middle_Characters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(middleChar(scan.nextLine()));
    }
    public static String middleChar (String text) {
        String result;
        int position = text.length() / 2;
        if (text.length() % 2 != 0) {
            result = "" + text.charAt(position);
        } else {
            result = "" + text.charAt(position - 1) + "" + text.charAt(position);
        }
        return result;
    }
}