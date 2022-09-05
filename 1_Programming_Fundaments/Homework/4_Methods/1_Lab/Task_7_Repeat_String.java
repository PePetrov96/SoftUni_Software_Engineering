import java.util.Scanner;

public class Task_7_Repeat_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(repeatString(sc.nextLine(), Integer.parseInt(sc.nextLine())));
    }
    private static String repeatString (String text, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result = result + text;
        }
        return result;
    }
}