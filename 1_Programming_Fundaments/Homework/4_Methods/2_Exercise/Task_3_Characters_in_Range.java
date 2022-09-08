import java.util.Scanner;

public class Task_3_Characters_in_Range {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char char1 = scan.nextLine().charAt(0);
        char char2 = scan.nextLine().charAt(0);
        System.out.println(charactersList(char1, char2));
    }
    public static String charactersList (char char1, char char2) {
        String text = "";
        for (int i = Math.min(char1, char2) + 1; i < Math.max(char1, char2); i++) {
            text = text + (char) i + " ";
        }
        return text;
    }
}