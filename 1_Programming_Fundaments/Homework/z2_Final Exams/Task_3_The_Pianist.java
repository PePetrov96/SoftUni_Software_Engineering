import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3_The_Pianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, PieceSpecs> pieceList = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            addPiece(pieceList, scan.nextLine().split("\\|"));
        }

        String input;
        while (!"Stop".equals(input = scan.nextLine())) {
            String[] tokens = input.split("\\|");

            switch (tokens[0]) {
                case "Add": addPiece(pieceList, tokens); break;
                case "Remove": remove(pieceList, tokens[1]); break;
                case "ChangeKey": changeKey(pieceList, tokens[1], tokens[2]); break;
            }
        }

        pieceList.forEach((key1, value) -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                key1, value.composer, value.pieceKey));
    }
    private static void addPiece (Map<String, PieceSpecs> pieceList, String[] tokens) {
        if (tokens[0].equals("Add") && pieceList.containsKey(tokens[1])) {
            System.out.printf("%s is already in the collection!%n", tokens[1]);
        } else if (tokens[0].equals("Add") && !pieceList.containsKey(tokens[1])) {
            PieceSpecs specs = new PieceSpecs();
            specs.composer = tokens[2]; specs.pieceKey = tokens[3];
            pieceList.putIfAbsent(tokens[1], specs);
            System.out.printf("%s by %s in %s added to the collection!%n", tokens[1], tokens[2], tokens[3]);
        } else {
            PieceSpecs specs = new PieceSpecs();
            specs.composer = tokens[1]; specs.pieceKey = tokens[2];
            pieceList.putIfAbsent(tokens[0], specs);
        }
    }
    private static void remove (Map<String, PieceSpecs> pieceList, String piece) {
        if (pieceList.containsKey(piece)) {
            pieceList.remove(piece);
            System.out.printf("Successfully removed %s!%n", piece);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }
    private static void changeKey (Map<String, PieceSpecs> pieceList, String piece, String newKey) {
        if (!pieceList.containsKey(piece)) {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        } else {
            pieceList.get(piece).pieceKey = newKey;
            System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
        }
    }
    private static class PieceSpecs {
        String composer;
        String pieceKey;
    }
}
