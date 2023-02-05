import java.util.Scanner;

public class Task_6_Replace_Repeating_Chars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scan.nextLine());

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i-1)) {
                input.delete(i-1, i);
                i--;
            }
        }

        System.out.println(input);
    }
}