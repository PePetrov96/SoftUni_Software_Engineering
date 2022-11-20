import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Fancy_Barcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();

            if (isValid(input)) {
                returnProduct(input);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
    public static boolean isValid (String input) {
        Pattern p = Pattern.compile("^@#+([A-Z][a-zA-Z0-9]{4,}[A-Z])@#+$");
        Matcher m = p.matcher(input);
        return m.matches();
    }
    public static void returnProduct (String input) {
        StringBuilder result = new StringBuilder();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(input);

        while (m.find()) {
            result.append(m.group());
        }

        if (result.toString().isEmpty()) {
            result.append("00");
        }

        System.out.println("Product group: " + result);
    }
}