import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Destination_Mapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Pattern p = Pattern.compile("([=|/])(?<location>[A-Z][A-Za-z]{2,})\\1");
        Matcher m = p.matcher(input);

        List<String> locations = new ArrayList<>();
        int sum = 0;

        while (m.find()) {
            locations.add(m.group("location"));
            sum += m.group("location").length();
        }

        System.out.println("Destinations: " + locations.toString().replaceAll("[\\[\\]]", ""));
        System.out.println("Travel Points: " + sum);
    }
}