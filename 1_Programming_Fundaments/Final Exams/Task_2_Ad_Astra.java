import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Ad_Astra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        List<String> foods = new ArrayList<>();
        int totalCalories = 0;

        Pattern p = Pattern.compile("([#|])(?<food>[A-Za-z ]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>[0-9]+)\\1");
        Matcher m = p.matcher(text);

        while (m.find()) {
            foods.add(String.format("Item: %s, Best before: %s, Nutrition: %s", m.group("food"), m.group("date"), m.group("calories")));
            totalCalories += Integer.parseInt(m.group("calories"));
        }

        System.out.printf("You have food to last you for: %d days!%n", (totalCalories / 2000));
        foods.forEach(System.out::println);
    }
}