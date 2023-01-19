import java.util.Scanner;

public class Task_1_The_Imitation_Game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String codedMessage = scan.nextLine();
        String input;

        while (!"Decode".equals(input = scan.nextLine())) {
            String[] token = input.split("\\|");
            switch (token[0]) {
                case "Move":
                    codedMessage = codedMessage.substring(Integer.parseInt(token[1]))
                            .concat(codedMessage.substring(0, Integer.parseInt(token[1])));
                    break;
                case "Insert":
                    codedMessage = codedMessage.substring(0, Integer.parseInt(token[1]))
                            .concat(token[2]).concat(codedMessage.substring(Integer.parseInt(token[1])));
                    break;
                case "ChangeAll":
                    codedMessage = codedMessage.replace(token[1], token[2]);
                    break;
            }
        }
        System.out.println("The decrypted message is: " + codedMessage);
    }
}