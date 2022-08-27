import java.util.Scanner;

public class Task_4_Reverse_String {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String reversed = "";
        char rev;

        for (int i = 0; i < input.length(); i++) {
            rev = input.charAt(i);
            reversed = rev + reversed;
        }
        System.out.println(reversed);
    }
}