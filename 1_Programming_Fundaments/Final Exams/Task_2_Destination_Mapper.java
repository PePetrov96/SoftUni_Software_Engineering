import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Destination_Mapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> destinations = new ArrayList<>();
        int score = 0;

        Pattern p = Pattern.compile("([=/])(?<place>[A-Z][a-zA-Z]{2,})\\1");
        Matcher m = p.matcher(input);

        while (m.find()) {
            destinations.add(m.group("place"));
            score += m.group("place").length();
        }

        System.out.println("Destinations: " + destinations.toString().replaceAll("[\\[\\]]", ""));
        System.out.println("Travel Points: " + score);
    }
}