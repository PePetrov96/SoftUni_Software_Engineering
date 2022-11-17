import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_3_Post_Office {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        output(input);
    }
    private static Map<String, String> getCapitals (String input) {
        Map<String, String> result = new LinkedHashMap<>();
        Pattern p = Pattern.compile("([#$%*&])(?<letters>[A-Z]+)\\1");
        Matcher m = p.matcher(input);

        while (m.find()) {
            for (int i = 0; i < m.group("letters").length(); i++) {
                result.put(String.valueOf(m.group("letters").charAt(i)), "");
            }
        }

        return result;
    }
    private static Map<String, String> getPositions (String input, Map<String, String> capitals) {
        Pattern p = Pattern.compile("(?<char>[0-9]{2}):(?<length>[0-9]{2})");
        Matcher m = p.matcher(input);

        while (m.find()) {
            String character = String.valueOf((char) Integer.parseInt(m.group("char")));
            int length = Integer.parseInt(String.valueOf(m.group("length").charAt(0))) * 10 +
                    Integer.parseInt(String.valueOf(m.group("length").charAt(1)));
            if (capitals.containsKey(character)) {
                capitals.put(character, String.valueOf(length));
            }
        }
        return capitals;
    }

    private static void output (String[] input) {
        Map<String, String> positions = getPositions(input[1], getCapitals(input[0]));

        positions.forEach((capital, value) -> {
            int position = Integer.parseInt(String.valueOf(value));
            Pattern p = Pattern.compile("(\\s|^)(?<word>(?<capital>["+capital+"])[\\s\\S]{"+position+"})(\\s|$)");
            Matcher m = p.matcher(input[2]);
            while (m.find()) {
                if (positions.containsKey(m.group("capital"))) {
                    positions.put(m.group("capital"), m.group("word"));
                }
            }
        });

        positions.forEach((key, value) -> System.out.println(value));
    }
}