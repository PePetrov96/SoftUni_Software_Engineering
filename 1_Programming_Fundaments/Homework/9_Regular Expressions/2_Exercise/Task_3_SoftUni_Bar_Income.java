import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3_SoftUni_Bar_Income {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalProfit = 0;

        String string;
        while (!"end of shift".equals(string = scan.nextLine())) {
            final String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>[0-9]+)\\|[^|$%.]*?(?<price>[-+]?[0-9]*\\.?[0-9]+)\\$";
            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(string);

            while (matcher.find()) {
                double result = Integer.parseInt(matcher.group("quantity")) * Double.parseDouble(matcher.group("price"));
                System.out.printf("%s: %s - %.2f%n", matcher.group("name"), matcher.group("product"), result);
                totalProfit += result;
            }
        }

        System.out.printf("Total income: %.2f", totalProfit);
    }
}