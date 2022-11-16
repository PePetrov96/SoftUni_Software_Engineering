import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Match_Phone_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\+359([- ])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(scan.nextLine());

        List<String> result = new ArrayList<>();

        while (matcher.find()) {
            result.add(matcher.group());
        }

        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }
}