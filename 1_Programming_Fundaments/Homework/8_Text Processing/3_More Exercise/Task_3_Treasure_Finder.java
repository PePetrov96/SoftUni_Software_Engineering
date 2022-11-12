import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task_3_Treasure_Finder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] keys = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input;

        while (!"find".equals(input = scan.nextLine())) {
            List<String> chars = Arrays.stream(input.split("")).collect(Collectors.toList());
            int keyL = 0;

            for (int i = 0; i < chars.size(); i++) {
                String some = (char) ((chars.get(i).charAt(0) - keys[keyL])) + "";
                chars.set(i, some);
                keyL++;
                if (keyL == keys.length) {
                    keyL = 0;
                }
            }
            String output = chars.toString().replaceAll("[\\[\\], ]", "");

            Pattern element = Pattern.compile("&.*&");
            Pattern coordinates = Pattern.compile("<.*>");
            Matcher m = element.matcher(output);
            Matcher n = coordinates.matcher(output);

            if (m.find() && n.find()) {
                System.out.printf("Found %s at %s%n",
                        m.group().replaceAll("&", ""),
                        n.group().replaceAll(">", "").replaceAll("<",""));
            }
        }
    }
}