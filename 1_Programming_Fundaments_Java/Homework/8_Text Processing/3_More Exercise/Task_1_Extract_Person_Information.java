import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_1_Extract_Person_Information {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rows; i++) {
            String input = scan.nextLine();
            Matcher m = Pattern.compile("@[a-zA-Z]+\\|", Pattern.CASE_INSENSITIVE).matcher(input);
            Matcher n = Pattern.compile("#[0-9]+\\*").matcher(input);

            if (m.find() && n.find()) {
                System.out.printf("%s is %s years old.%n",
                        m.group().replaceAll("[^a-zA-z]", ""),
                        n.group().replaceAll("[^0-9]", ""));
            }
        }
    }
}