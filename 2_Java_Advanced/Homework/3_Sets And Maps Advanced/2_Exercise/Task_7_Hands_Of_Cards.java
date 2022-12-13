import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task_7_Hands_Of_Cards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, HashSet<String>> scoreBoard = new LinkedHashMap<>();

        String input;
        while (!"JOKER".equals(input = reader.readLine())) {
            updateEntries(scoreBoard, input.split(":\\s+")[0], input.split(":\\s+")[1].split(",\\s+"));
        }

        resultingScores(scoreBoard)
                .forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
    private static LinkedHashMap<String, Integer> resultingScores (LinkedHashMap<String, HashSet<String>> scoreBoard) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        for (Map.Entry<String, HashSet<String>> entry : scoreBoard.entrySet()) {
            final int[] sum = {0};
            entry.getValue().forEach((card) -> sum[0] += getCardSum(card));
            result.put(entry.getKey(), sum[0]);
        }

        return result;
    }
    private static int getCardSum (String card) {
        int cardScore;
        String[] tokens = card.split("");
        String cardPower = tokens[0];
        String cardModifier = tokens[tokens.length-1];

        if (tokens.length == 3) {
            cardScore = 10;
        } else {
            switch (cardPower) {
                case "A": cardScore = 14; break;
                case "K": cardScore = 13; break;
                case "Q": cardScore = 12; break;
                case "J": cardScore = 11; break;
                default: cardScore = Integer.parseInt(cardPower);
            }
        }

        int multiplier = 0;
        switch (cardModifier) {
            case "S": multiplier = 4; break;
            case "H": multiplier = 3; break;
            case "D": multiplier = 2; break;
            case "C": multiplier = 1; break;
        }

        return cardScore * multiplier;
    }
    private static void updateEntries (LinkedHashMap<String, HashSet<String>> scoreBoard, String name, String[] cards) {
        if (!scoreBoard.containsKey(name)) {
            scoreBoard.put(name, new HashSet<>());
        }

        for (String card : cards) {
            scoreBoard.get(name).add(card);
        }

    }
}