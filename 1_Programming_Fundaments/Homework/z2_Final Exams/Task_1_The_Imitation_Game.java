import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_1_The_Imitation_Game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String encryptedMessage = scan.nextLine();

        String input;

        while (!"Decode".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\|");
            switch (tokens[0]) {
                case "Move":
                    int n = Integer.parseInt(tokens[1]);
                    encryptedMessage = encryptedMessage.substring(n).concat(encryptedMessage.substring(0, n));
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    encryptedMessage = encryptedMessage.substring(0,index).concat(tokens[2]).concat(encryptedMessage.substring(index));
                    break;
                case "ChangeAll":
                    encryptedMessage = encryptedMessage.replaceAll(Pattern.quote(tokens[1]), tokens[2]);
                    break;
            }
        }
        System.out.println("The decrypted message is: " + encryptedMessage);
    }
}