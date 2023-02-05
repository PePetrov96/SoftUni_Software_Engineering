import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Rage_Quit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder result = new StringBuilder();
        Matcher m = Pattern.compile("(?<string>\\D+)(?<repeat>\\d+)").matcher(input);

        while (m.find()) {
            result.append(m.group("string").toUpperCase().repeat(Math.max(0, Integer.parseInt(m.group("repeat")))));
        }

        List<Character> uniqueCount = new ArrayList<>();

        for (int i = 0; i < result.length(); i++) {
            if (!uniqueCount.contains(result.charAt(i))) {
                uniqueCount.add(result.charAt(i));
            }
        }

        System.out.println("Unique symbols used: " + uniqueCount.size());
        System.out.println(result);
    }
}
