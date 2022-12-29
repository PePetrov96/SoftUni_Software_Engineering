import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Cards.Ranks rank = Cards.Ranks.valueOf(reader.readLine());
        Cards.Suits suit = Cards.Suits.valueOf(reader.readLine());

        Cards.printPower(suit, rank);
    }
}