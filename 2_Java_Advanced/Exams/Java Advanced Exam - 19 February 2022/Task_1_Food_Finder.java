import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task_1_Food_Finder {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Deque<String> vowels;
    static Stack<String> consonants;
    static LinkedHashMap<String, List<Character>> words;
    public static void main(String[] args) throws IOException {
        initialize();

        checkChars();

        printResult();
    }

    private static void printResult() {
        int count = (int) words.entrySet().stream()
                .filter(word -> word.getValue().size() == 0)
                .count();

        System.out.println("Words found: " + count);

        words.entrySet().stream()
                .filter(word -> word.getValue().size() == 0)
                .forEach(word -> System.out.println(word.getKey()));
    }
    private static void checkChars() {
        while (!consonants.isEmpty()) {

            char currVowel = vowels.remove().charAt(0);
            char currCons = consonants.pop().charAt(0);

            for (Map.Entry<String, List<Character>> word : words.entrySet()) {

                for (int i = 0; i < word.getValue().size(); i++) {

                    if (currVowel == word.getValue().get(i) ||
                            currCons == word.getValue().get(i)) {

                        word.getValue().remove(i);
                        i--;
                    }
                }

            }

            vowels.addLast(String.valueOf(currVowel));
        }

    }
    private static void initialize() throws IOException {
        vowels = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        consonants = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(Stack::new));

        words = new LinkedHashMap<>();

        words.put("pear", new ArrayList<>());
        Collections.addAll(words.get("pear"), 'p', 'e', 'a', 'r');

        words.put("flour", new ArrayList<>());
        Collections.addAll(words.get("flour"), 'f', 'l', 'o', 'u', 'r');

        words.put("pork", new ArrayList<>());
        Collections.addAll(words.get("pork"), 'p', 'o', 'r', 'k');

        words.put("olive", new ArrayList<>());
        Collections.addAll(words.get("olive"), 'o', 'l', 'i', 'v', 'e');

    }
}