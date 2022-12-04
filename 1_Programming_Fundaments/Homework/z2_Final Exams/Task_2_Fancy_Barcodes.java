import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Fancy_Barcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            result(scan.nextLine());
        }
    }
    private static void result (String input) {
        Pattern p = Pattern.compile("(^@#{1,})(?<product>[A-Z][a-zA-Z0-9]{4,}[A-Z])(@#{1,})$");
        Matcher m = p.matcher(input);

        if (m.matches()) {
            productCode(m.group("product"));
        } else {
            System.out.println("Invalid barcode");
        }
    }
    private static void productCode (String product) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(product);

        while (m.find()) {
            result.append(m.group());
        }

        if (result.toString().isEmpty()) {
            System.out.println("Product group: 00");
        } else {
            System.out.println("Product group: " + result);
        }
    }
}