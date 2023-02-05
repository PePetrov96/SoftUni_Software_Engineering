import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_4_Santas_Secret_Helper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int key = Integer.parseInt(scan.nextLine());
        List<String> niceKids = new ArrayList<>();
        String input;

        while (!"end".equals(input = scan.nextLine())) {
            updateList(input, key, niceKids);
        }

        niceKids.forEach(System.out::println);
    }
    private static String decipher (String input, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = (char) (input.charAt(i) - key);
            result.append(c);
        }
        return result.toString();
    }

    private static void updateList (String input, int key, List<String> niceKids) {
        String text = decipher(input, key);
        Pattern p = Pattern.compile("@(?<name>[a-zA-Z]+)[^@\\-!:>]*!(?<status>[GN])!");
        Matcher m = p.matcher(text);

        while (m.find()) {
            if (m.group("status").equals("G")) {
                niceKids.add(m.group("name"));
            }
        }
    }
}