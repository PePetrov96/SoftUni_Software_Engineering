import java.util.Scanner;

public class Task_4_Text_Filter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWords = scan.nextLine().split(", ");
        StringBuilder text = new StringBuilder(scan.nextLine());

        for (String bannedWord : bannedWords) {
            while (text.indexOf(bannedWord) != -1) {
                text.replace(text.indexOf(bannedWord), text.indexOf(bannedWord) + bannedWord.length(), "*".repeat(bannedWord.length()));
            }
        }
        System.out.println(text);
    }
}