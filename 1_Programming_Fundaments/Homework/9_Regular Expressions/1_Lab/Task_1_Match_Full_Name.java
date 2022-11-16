import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_1_Match_Full_Name {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Matcher matcher = Pattern.compile("\\b([A-Z][a-z]+) ([A-Z][a-z]+)\\b").matcher(scan.nextLine());

        while (matcher.find()) {
            System.out.printf(matcher.group() + " ");
        }
    }
}