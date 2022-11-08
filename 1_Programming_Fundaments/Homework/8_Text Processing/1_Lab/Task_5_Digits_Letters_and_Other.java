import java.util.Scanner;

public class Task_5_Digits_Letters_and_Other {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] result = {"", "", ""};

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                result[0] += input.charAt(i);
            } else if (Character.isLetter(input.charAt(i))) {
                result[1] += input.charAt(i);
            } else {
                result[2] += input.charAt(i);
            }
        }

        System.out.printf("%s%n%s%n%s%n", result[0], result[1], result[2]);
    }
}