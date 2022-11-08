import java.util.Scanner;

public class Task_1_Reverse_Strings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;

        while (!"end".equals(input = scan.nextLine())) {
            String reversed = "";
            for (int i = input.length()-1; i >= 0; i--) {
                reversed += input.charAt(i);
            }
            System.out.printf("%s = %s%n", input, reversed);
        }
    }
}