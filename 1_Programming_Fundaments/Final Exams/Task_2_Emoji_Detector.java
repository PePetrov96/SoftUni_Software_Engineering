import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Emoji_Detector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        printResult(scan.nextLine());
    }
    private static void printResult (String input) {
        Map<String, Integer> emojis = emojis(input);
        BigInteger threshold = coolThreshold(input);

        System.out.println("Cool threshold: " + threshold);
        System.out.println(emojis.keySet().size() + " emojis found in the text. The cool ones are:");

        emojis.forEach((key, value) -> {
            if (threshold.compareTo(BigInteger.valueOf(value)) < 0) {
                System.out.println(key);
            }
        });
    }
    private static Map<String, Integer> emojis (String input) {
        Map<String, Integer> result = new LinkedHashMap<>();
            Pattern p = Pattern.compile("(:{2}|\\*{2})(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher m = p.matcher(input);

        while (m.find()) {
            int sum = 0;
            for (int i = 0; i < m.group("emoji").length(); i++) {
                sum += m.group("emoji").charAt(i);
            }
            result.put(m.group(), sum);
        }

        return result;
    }
    private static BigInteger coolThreshold (String text) {
        BigInteger result = new BigInteger("1");
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(text);

        while (m.find()) {
            result = result.multiply(BigInteger.valueOf(Integer.parseInt(m.group())));
        }

        return result;
    }
}