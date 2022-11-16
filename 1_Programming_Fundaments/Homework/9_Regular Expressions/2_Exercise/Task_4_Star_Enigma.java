import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_4_Star_Enigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            updateEntry(scan.nextLine(), attacked, destroyed);

        }
        printResult(attacked, destroyed);
    }
    private static void updateEntry (String input, List<String> attacked, List<String> destroyed) {
        final Pattern p = Pattern.compile("@(?<name>[a-zA-Z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<type>[AD])![^@\\-!:>]*->(?<count>[0-9]+)");
        int key = input.replaceAll("[^starSTAR]", "").length();
        StringBuilder result = new StringBuilder();

        for (int j = 0; j < input.length(); j++) {
            int t = input.charAt(j) - key;
            result.append((char) t);
        }
        Matcher m = p.matcher(result.toString());
        while (m.find()) {
            if (m.group("type").equals("A")) {
                attacked.add(m.group("name"));
            } else if (m.group("type").equals("D")) {
                destroyed.add(m.group("name"));
            }
        }
    }
    private static void printResult (List<String> attacked, List<String> destroyed) {
        Collections.sort(attacked);
        Collections.sort(destroyed);
        System.out.printf("Attacked planets: %d%n", attacked.size());
        attacked.forEach(e -> System.out.printf("-> %s%n", e));
        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        destroyed.forEach(e -> System.out.printf("-> %s%n", e));
    }
}