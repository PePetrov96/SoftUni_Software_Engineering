import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_1_Valid_Usernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] usernames = scan.nextLine().split(", ");

        for (String username : usernames) {
            Pattern p = Pattern.compile("[^a-z0-9-_]", Pattern.CASE_INSENSITIVE);

            if (!p.matcher(username).find() && username.length() >= 3 && username.length() <= 16) {
                System.out.println(username);
            }
        }
    }
}