import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2_Mirror_Words {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        List<String> pairWords = pairs(text);

        if (pairWords.isEmpty()) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(pairWords.size() + " word pairs found!");
        }

        List<String> mirrorWords = mirrors(pairWords);

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(mirrorWords.toString().replaceAll("[\\[\\]]", ""));
        }
    }
    private static List<String> pairs (String text) {
        List<String> result = new ArrayList<>();
        Pattern p = Pattern.compile("([@#])(?<first>[a-zA-Z]{3,})\\1\\1(?<second>[a-zA-Z]{3,})\\1");
        Matcher m = p.matcher(text);

        while (m.find()) {
            result.add(m.group("first").concat(" ").concat(m.group("second")));
        }
        return result;
    }
    private static List<String> mirrors (List<String> pairWords) {
        List<String> result = new ArrayList<>();

        for (String pairWord : pairWords) {
            String first = pairWord.split("\\s")[0];
            String second = pairWord.split("\\s")[1];
            String checker = new StringBuilder(second).reverse().toString();
            if (first.equals(checker)) {
                result.add(first.concat(" <=> ").concat(second));
            }
        }
        return result;
    }
}