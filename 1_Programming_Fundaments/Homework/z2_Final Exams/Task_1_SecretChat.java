import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_1_SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String secretMessage = scan.nextLine();

        String input;

        while (!"Reveal".equals(input = scan.nextLine())) {
            String[] tokens = input.split(":\\|:");
            switch (tokens[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    secretMessage = secretMessage.substring(0, index).concat(" ").concat(secretMessage.substring(index));
                    System.out.println(secretMessage);
                    break;
                case "Reverse":
                    String forCheck = tokens[1];
                    if (secretMessage.contains(forCheck)) {
                        String forReplays = new StringBuilder(forCheck).reverse().toString();
                        secretMessage = secretMessage.replaceFirst(Pattern.quote(forCheck), "").concat(forReplays);
                        System.out.println(secretMessage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    secretMessage = secretMessage.replace(tokens[1], tokens[2]);
                    System.out.println(secretMessage);
                    break;
            }
        }
        System.out.println("You have a new text message: " + secretMessage);
    }
}