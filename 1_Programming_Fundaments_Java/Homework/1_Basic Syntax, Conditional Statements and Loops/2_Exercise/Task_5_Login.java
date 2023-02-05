import java.util.Scanner;

public class Task_5_Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = "";
        char pass;
        int attempts = 0;

        for (int i = 0; i < username.length(); i++) {
            pass = username.charAt(i);
            password = pass + password;
        }
        while (true) {
            String input = scan.nextLine();
            if (input.equals(password)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {
                if (attempts < 3) {
                    attempts++;
                    System.out.println("Incorrect password. Try again.");
                } else {
                    System.out.printf("User %s blocked!", username);
                    break;
                }
            }
        }
    }
}