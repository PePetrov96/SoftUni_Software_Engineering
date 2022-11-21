import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Ad_Astra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("([#|])(?<name>[A-Za-z ]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>[0-9]+)\\1");
        Matcher match = pattern.matcher(input);

        int totalCalories = 0;
        while (match.find()) {
            totalCalories += Integer.parseInt(match.group("calories"));
            result.add("Item: " + match.group("name") + ", Best before: " + match.group("date") + ", Nutrition: " + match.group("calories"));
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        result.forEach(System.out::println);
    }
}