import java.util.Scanner;

public class Task_2_Vowels_Count {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        System.out.println(vowelCount(text));
    }
    public static int vowelCount (String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'o' ||
                    text.charAt(i) == 'u' || text.charAt(i) == 'i' || text.charAt(i) == 'A' ||
                    text.charAt(i) == 'E' || text.charAt(i) == 'O' || text.charAt(i) == 'U' ||
                    text.charAt(i) == 'I') {
                count++;
            }
        }
        return count;
    }
}