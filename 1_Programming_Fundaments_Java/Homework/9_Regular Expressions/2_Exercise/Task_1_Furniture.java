import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_1_Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> products = new ArrayList<>();
        String input; double total = 0;
        Pattern p = Pattern.compile(">>(?<item>[A-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)");

        while (!"Purchase".equals(input = scan.nextLine())) {
            Matcher m = p.matcher(input);

            while (m.find()) {
                products.add(m.group("item"));
                total += (Double.parseDouble(m.group("price")) * Integer.parseInt(m.group("quantity")));
            }

        }
        System.out.println("Bought furniture:");
        products.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", total);
    }
}