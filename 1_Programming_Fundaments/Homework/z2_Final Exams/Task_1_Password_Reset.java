import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_1_Password_Reset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        String input;

        while (!"Done".equals(input = scan.nextLine())) {
            String[] commands = input.split("\\s");

            switch (commands[0]) {
                case "TakeOdd": password = TakeOdd(password); break;
                case "Cut": password = Cut(password, Integer.parseInt(commands[1]), Integer.parseInt(commands[2])); break;
                case "Substitute": password = Substitute(password, commands[1], commands[2]); break;
            }
        }

        System.out.println("Your password is: " + password);
    }
    private static String Substitute (String password, String oldString, String newString) {
        if (password.contains(oldString)) {
            password = password.replaceAll(Pattern.quote(oldString), newString);
            System.out.println(password);
        } else {
            System.out.println("Nothing to replace!");
        }
        return password;
    }
    private static String Cut (String password, int start, int length) {
        int end = start + length;
        password = password.substring(0, start).concat(password.substring(end));
        System.out.println(password);
        return password;
    }
    private static String TakeOdd (String password) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                result.append(password.charAt(i));
            }
        }
        System.out.println(result);
        return result.toString();
    }
}