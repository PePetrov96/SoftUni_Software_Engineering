import java.util.Scanner;

public class Task_3_Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        StringBuilder text = new StringBuilder(scan.nextLine());

        while (text.indexOf(key) != -1) {
            text.replace(text.indexOf(key), text.indexOf(key) + key.length(), "");
        }

        System.out.println(text);
    }
}