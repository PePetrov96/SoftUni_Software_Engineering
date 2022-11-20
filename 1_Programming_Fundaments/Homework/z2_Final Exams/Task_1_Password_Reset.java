import java.util.Scanner;

public class Task_1_Password_Reset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        String input;

        while (!"Done".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "TakeOdd":
                    password = TakeOdd(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    password = Cut(password, tokens[1], tokens[2]);
                    break;
                case "Substitute":
                    password = Substitute(password, tokens[1], tokens[2]);
                    break;
            }
        }
        System.out.println("Your password is: " + password);
    }
    private static String TakeOdd (String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < text.length(); i++) {
            if (i % 2 != 0) {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }
    private static String Cut (String password, String indexStr, String lengthStr) {
        int start = Integer.parseInt(indexStr);
        int end = start + Integer.parseInt(lengthStr);
        password = password.substring(0, start) + password.substring(end);
        System.out.println(password);
        return password;
    }
    private static String Substitute (String password, String substring, String substitute) {
        if (password.contains(substring)) {
            password = password.replaceAll(substring, substitute);
            System.out.println(password);
            return password;
        } else {
            System.out.println("Nothing to replace!");
            return password;
        }
    }
}