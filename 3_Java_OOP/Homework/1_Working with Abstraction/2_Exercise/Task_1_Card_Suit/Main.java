import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();

        if (firstLine.equals("Card Suits")) {
            printSuits();
        } else if (firstLine.equals("Card Ranks")) {
            printRanks();
        }
    }

    private static void printRanks() {
        System.out.println("Card Ranks:");

        for (Cards.Ranks rank : Cards.Ranks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", rank.getValue(), rank);
        }
    }
    private static void printSuits() {
        System.out.println("Card Suits:");

        for (Cards.Suits suit : Cards.Suits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.getValue(), suit);
        }
    }
}
