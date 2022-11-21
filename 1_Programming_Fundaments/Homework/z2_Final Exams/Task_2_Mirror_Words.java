import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Mirror_Words {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        List<String> words = new ArrayList<>();
        getPairs(input, words);

        if (words.isEmpty()) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(words.size() + " word pairs found!");
        }

        List<String> mirrors = new ArrayList<>();
        getMirrors(mirrors, words);

        if (mirrors.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(mirrors.toString().replaceAll("[\\[\\]]", ""));
        }

    }
    private static void getPairs (String input, List<String> words) {
        Pattern pairs = Pattern.compile("([#@])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matchPairs = pairs.matcher(input);

        while (matchPairs.find()) {
            words.add(matchPairs.group("wordOne") + "-" + matchPairs.group("wordTwo"));
        }
    }

    private static void getMirrors (List<String> mirrors, List<String> words) {
        for (String word : words) {
            String first = word.split("-")[0];
            String second = word.split("-")[1];
            if (first.length() == second.length()) {
                boolean isMirror = true;
                for (int j = 0; j < first.length(); j++) {
                    if (first.charAt(j) != second.charAt(second.length() - j - 1)) {
                        isMirror = false;
                        break;
                    }
                }
                if (isMirror) {
                    mirrors.add((first + " <=> " + second));
                }
            }
        }
    }
}