import java.util.Scanner;

public class Task_5_Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int textLength = Integer.parseInt(scan.nextLine());
        String text = "";
        int input = 0;

        for (int i = 0; i < textLength; i++) {
            input = Integer.parseInt(scan.nextLine());
            char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
            int length = String.valueOf(input).length();
            int mainDigit = input % 10;
            int offset = 0;
            if (mainDigit >= 2 && mainDigit <= 7) {
                offset = (mainDigit - 2) * 3;
            } else if (mainDigit == 8 || mainDigit == 9) {
                offset = (mainDigit - 2) * 3 + 1;
            } else if (mainDigit == 0) {
                offset = 26;
            }
            int index = offset + length - 1;
            text = text + letter[index];
        }
        System.out.println(text);
    }
}