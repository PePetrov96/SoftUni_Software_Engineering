import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Blind_Mans_Buff {
    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static char[][] playground;
    static byte row;
    static byte col;
    static byte sizeRows;
    static byte sizeCols;
    static int total_moves;
    static int touched_opponents;

    public static void main(String[] args) throws IOException {
        initialize();

        String input;
        while (!"Finish".equals(input = reader.readLine()) && touched_opponents < 3) {
            move(input);
        }

        printResult();
    }
    private static void printResult() {
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touched_opponents, total_moves);
    }

    private static void move(String direction) {
        switch (direction) {
            case "up":
                if (row-1 >= 0) {
                    if (playground[row-1][col] != 'O') {
                        row--;
                        total_moves++;
                    }
                }
                break;
            case "down":
                if (row+1 < sizeRows) {
                    if (playground[row+1][col] != 'O') {
                        row++;
                        total_moves++;
                    }
                }
                break;
            case "left":
                if (col-1 >= 0) {
                    if (playground[row][col-1] != 'O') {
                        col--;
                        total_moves++;
                    }
                }
                break;
            case "right":
                if (col+1 <sizeCols) {
                    if (playground[row][col+1] != 'O') {
                        col++;
                        total_moves++;
                    }
                }
                break;
        }

        checkPosition();
    }
    private static void checkPosition() {
        if (playground[row][col] == 'P') {
            touched_opponents++;
            playground[row][col] = '-';
        }
    }
    private static void initialize() throws IOException {
        int[] sizes = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        sizeRows = (byte) sizes[0];
        sizeCols = (byte) sizes[1];

        playground = new char[sizeRows][sizeCols];

        for (byte atRow = 0; atRow < sizeRows; atRow++) {
            String line = reader.readLine().replaceAll("\\s","");

            if (line.contains("B")) {
                check(line, atRow);
            }

            playground[atRow] = line.replaceAll("B","-").toCharArray();
        }
    }

    private static void check(String line, byte atRow) {
        for (byte atCol = 0; atCol < line.length(); atCol++) {
            char curr = line.charAt(atCol);

            if (curr == 'B') {
                row = atRow;
                col = atCol;
            }
        }
    }
}