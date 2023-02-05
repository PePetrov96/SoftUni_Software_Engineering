import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_6_Extract_Emails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Pattern p = Pattern.compile("(?<username>[A-Za-z0-9][A-Za-z0-9.\\-_]+[A-Za-z0-9])@(?<host>([a-zA-Z]+[-|.])+.[a-zA-Z]+)");
        Matcher m = p.matcher(input);

        while (m.find()) {
            System.out.println(m.group());
        }

    }
}