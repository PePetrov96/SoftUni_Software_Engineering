import java.util.Scanner;

public class Task_2_Character_Multiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split("\\s+");
        int result = 0;

        for (int i = 0; i < Math.max(text[0].length(), text[1].length()); i++) {
            try {
                result += (text[0].charAt(i) * text[1].charAt(i));
            } catch (IndexOutOfBoundsException e) {
                try {
                    result += text[0].charAt(i);
                } catch (IndexOutOfBoundsException f) {
                    result += text[1].charAt(i);
                }
            }
        }
        System.out.println(result);
    }
}