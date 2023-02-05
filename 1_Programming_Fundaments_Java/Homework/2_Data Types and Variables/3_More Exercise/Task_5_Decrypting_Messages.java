import java.util.Scanner;

public class Task_5_Decrypting_Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        String message = "";

        for (int i = 0; i < n; i++) {
            char letter = scan.nextLine().charAt(0);
            letter += key;
            message = message + letter;
        }
        System.out.println(message);
    }
}