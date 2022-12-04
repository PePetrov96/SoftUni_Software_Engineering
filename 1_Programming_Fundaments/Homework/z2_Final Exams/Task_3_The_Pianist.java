import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3_The_Pianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, PieceSpec> pieceList = new LinkedHashMap<>();

        String input = scan.nextLine();

        for (int i = 0; i < Integer.parseInt(input); i++) {
            Add(pieceList, scan.nextLine().split("\\|"));
        }

        while (!"Stop".equals(input = scan.nextLine())) {
            modifyList(pieceList, input.split("\\|"));
        }

        pieceList.forEach((key, value) -> System.out.printf("%s -> Composer: %s, Key: %s%n", key, value.composer, value.pieceKey));
    }
    private static void Add (Map<String, PieceSpec> pieceList, String[] input) {
        if (!input[0].equals("Add")) {
            PieceSpec specs = new PieceSpec(input[1], input[2]);
            pieceList.put(input[0], specs);
        } else if (pieceList.containsKey(input[1])) {
            System.out.printf("%s is already in the collection!%n", input[1]);
        } else {
            PieceSpec specs = new PieceSpec(input[2], input[3]);
            pieceList.put(input[1], specs);
            System.out.printf("%s by %s in %s added to the collection!%n", input[1], input[2], input[3]);
        }
    }
    private static void modifyList (Map<String, PieceSpec> pieceList, String[] input) {
        switch (input[0]) {
            case "Add": Add(pieceList, input); break;
            case "Remove": Remove(pieceList, input[1]); break;
            case "ChangeKey": ChangeKey(pieceList, input[1], input[2]); break;
        }
    }
    private static void Remove (Map<String, PieceSpec> pieceList, String piece) {
        if (pieceList.containsKey(piece)) {
            System.out.printf("Successfully removed %s!%n", piece);
            pieceList.remove(piece);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }
    private static void ChangeKey (Map<String, PieceSpec> pieceList, String piece, String newKey) {
        if (pieceList.containsKey(piece)) {
            pieceList.get(piece).pieceKey = newKey;
            System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }
    public static class PieceSpec {
        String composer;
        String pieceKey;
        public PieceSpec(String composer, String pieceKey) {
            this.composer = composer;
            this.pieceKey = pieceKey;
        }
    }
}