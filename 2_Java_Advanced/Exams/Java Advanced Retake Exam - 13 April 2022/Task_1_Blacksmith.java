import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task_1_Blacksmith {
    static Queue<Integer> steelSequence;
    static ArrayDeque<Integer> carbonSequence;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static byte gladius;
    static byte shamshir;
    static byte katana;
    static byte sabre;

    public static void main(String[] args) throws IOException {

        initializeCollections();

        mix();

        printResult();

    }
    private static void initializeCollections() throws IOException {
        steelSequence = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        carbonSequence = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
    private static void mix() {
        while (!steelSequence.isEmpty() && !carbonSequence.isEmpty()) {
            int steel = steelSequence.remove();
            int carbon = carbonSequence.pollLast();

            int sum = steel + carbon;

            switch (sum) {
                case 110: sabre++;
                    break;
                case 90: katana++;
                    break;
                case 80: shamshir++;
                    break;
                case 70: gladius++;
                    break;
                default: carbonSequence.addLast(carbon + 5);
            }
        }
    }
    private static void printResult() {
        boolean hasGladius = gladius > 0,
                hasShamshir = shamshir > 0,
                hasKatana = katana > 0,
                hasSabre = sabre > 0;

        System.out.println(hasGladius || hasShamshir || hasKatana || hasSabre ?
                String.format("You have forged %d swords.", (gladius + shamshir + katana +sabre)) :
                "You did not have enough resources to forge a sword.");

        if (steelSequence.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.println("Steel left: " + String.join(", ", steelSequence.toString().replaceAll("[\\[\\]]","")));
        }

        if (carbonSequence.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            StringBuilder result = new StringBuilder("Carbon left: ");

            Iterator<Integer> it = carbonSequence.descendingIterator();
            while(it.hasNext()) {
                result.append(it.next()).append(", ");
            }

            result.replace(result.length()-2, result.length(), "");

            System.out.println(result);
        }

        if (hasGladius) {
            System.out.println("Gladius: " + gladius);
        }

        if (hasKatana) {
            System.out.println("Katana: " + katana);
        }

        if (hasSabre) {
            System.out.println("Sabre: " + sabre);
        }

        if (hasShamshir) {
            System.out.println("Shamshir: " + shamshir);
        }


    }
}