import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_5_Nether_Realms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(",\\s*");

        for (String s : input) {
            String current = s.replaceAll("\\s+", "");
            System.out.printf("%s - %d health, %.2f damage%n", current, getHealth(current), getDamage(current));
        }

    }
    private static int getHealth (String input) {
        int health = 0;
        String name = input.replaceAll("[0-9+\\-*/.]", "");
        for (int i = 0; i < name.length(); i++) {
            health += name.charAt(i);
        }
        return health;
    }
    private static double getDamage (String input) {
        double result = 0;

        Pattern p = Pattern.compile("(?<operator>[+-]?)(?<digit>\\d+\\.?\\d*)");
        Matcher m = p.matcher(input);

        while (m.find()) {
            if (m.group("operator").equals("-")) {
                result -= Double.parseDouble(m.group("digit"));
            } else {
                result += Double.parseDouble(m.group("digit"));
            }
        }

        String modifier = input.replaceAll("[^*/]","");
        for (int i = 0; i < modifier.length(); i++) {
            if (modifier.charAt(i) == '*') { result *= 2; }
            else { result /= 2; }
        }

        return result;
    }
}