import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_1_SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String input;

        while (!"Reveal".equals(input = scan.nextLine())) {
            message = modify(message, input.split(":\\|:"));
        }

        System.out.println("You have a new text message: " + message);
    }
    private static String modify (String message, String[] input) {
        switch (input[0]) {
            case "InsertSpace":
                int index = Integer.parseInt(input[1]);
                message = message.substring(0, index).concat(" ").concat(message.substring(index));
                System.out.println(message);
                break;
            case "Reverse":
                if (message.contains(input[1])) {
                    String reversed = new StringBuilder(input[1]).reverse().toString();
                    message = message.replaceFirst(Pattern.quote(input[1]),"").concat(reversed);
                    System.out.println(message);
                } else {
                    System.out.println("error");
                }
                break;
            case "ChangeAll":
                message = message.replaceAll(Pattern.quote(input[1]), input[2]);
                System.out.println(message);
                break;
        }
        return message;
    }
}