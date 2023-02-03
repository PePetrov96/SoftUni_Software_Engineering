import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Task_2_Pawn_Wars {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static char[][] chessBoard;
    static byte whiteRow;
    static byte whiteCol;
    static byte blackRow;
    static byte blackCol;
    public static void main(String[] args) throws IOException {
        initializeBoard();

        determineWinner();
    }

    private static PrintStream determineWinner() {
        while (whiteRow != 0 && blackRow != 7) {
            if (whiteRow-1 == blackRow && (whiteCol-1 == blackCol || whiteCol+1 == blackCol)) {
                return System.out.printf("Game over! White capture on %s."
                        , returnPosition(blackRow, blackCol));
            }

            whiteRow--;

            if (blackRow+1 == whiteRow && (blackCol+1 == whiteCol || blackCol-1 == whiteCol)) {
                return System.out.printf("Game over! Black capture on %s."
                        , returnPosition(whiteRow, whiteCol));
            }

            blackRow++;
        }

        if (whiteRow == 0) {
            return System.out.printf("Game over! White pawn is promoted to a queen at %s."
                    , returnPosition(whiteRow, whiteCol));
        } else {
            return System.out.printf("Game over! Black pawn is promoted to a queen at %s."
                    , returnPosition(blackRow, blackCol));
        }
    }


    private static void initializeBoard() throws IOException {
        chessBoard = new char[8][8];

        for (byte i = 0; i < 8; i++) {
            String line = reader.readLine();

            if (line.contains("b") || line.contains("w")) {
                getPawn(i, line);
            }

            chessBoard[i] = line.toCharArray();
        }
    }
    private static void getPawn(byte row, String line) {
        for (byte i = 0; i < 8; i++) {
            if (line.charAt(i) == 'b') {
                blackRow = row;
                blackCol = i;
            }

            if (line.charAt(i) == 'w') {
                whiteRow = row;
                whiteCol = i;
            }
        }
    }
    private static String returnPosition(int row, int col) {
        switch (col) {
            case 0: return String.format("a%d", 8-row);
            case 1: return String.format("b%d", 8-row);
            case 2: return String.format("c%d", 8-row);
            case 3: return String.format("d%d", 8-row);
            case 4: return String.format("e%d", 8-row);
            case 5: return String.format("f%d", 8-row);
            case 6: return String.format("g%d", 8-row);
            case 7: return String.format("h%d", 8-row);
        }
        return null;
    }
}