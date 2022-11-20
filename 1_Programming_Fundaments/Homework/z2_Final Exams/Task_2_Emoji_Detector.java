import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Emoji_Detector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        printResult(scan.nextLine());
    }
    private static void printResult (String text) {
        Map<String, Integer> emojis = new LinkedHashMap<>();
        updateEntry(text, emojis);
        BigInteger threshold = getThreshold(text);
        System.out.println("Cool threshold: " + threshold);
        System.out.println(emojis.keySet().size() + " emojis found in the text. The cool ones are:");
        emojis.forEach((key1, value) -> {
            if (threshold.compareTo(BigInteger.valueOf(value)) < 0) {
                System.out.println(key1);
            }
        });
    }
    private static void updateEntry (String text, Map<String, Integer> emojis) {
        Pattern words = Pattern.compile("(:{2}|[*]{2})[A-Z][a-z]{2,}\\1");
        Pattern ascii = Pattern.compile("[A-Z][a-z]{2,}");
        Matcher m = words.matcher(text);

        while (m.find()){
            int sum = 0;
            Matcher ma = ascii.matcher(m.group());
            while (ma.find()) {
                for (int i = 0; i < ma.group().length(); i++) {
                    sum += ma.group().charAt(i);
                }
            }
            emojis.put(m.group(), sum);
        }
    }

    private static BigInteger getThreshold (String text) {
        BigInteger result = new BigInteger("1");
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(text);

        while (m.find()) {
            result = result.multiply(BigInteger.valueOf(Integer.parseInt(m.group())));
        }

        return result;
    }
}