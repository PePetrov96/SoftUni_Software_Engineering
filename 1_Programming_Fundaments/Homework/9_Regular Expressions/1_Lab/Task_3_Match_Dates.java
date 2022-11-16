import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3_Match_Dates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Matcher m = Pattern.compile("\\b(?<day>\\d{2})([-./])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b").matcher(scan.nextLine());

        while (m.find()) {
            System.out.printf("Day: %s, Month: %s, Year: %s%n", m.group("day"), m.group("month"), m.group("year"));
        }
    }
}