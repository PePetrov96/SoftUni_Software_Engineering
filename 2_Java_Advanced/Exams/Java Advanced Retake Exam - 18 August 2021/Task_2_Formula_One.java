import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Formula_One {
    static char[][] field;
    static int size;
    static int commandSize;
    static int row;
    static int col;
    static boolean wonRace = false;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        initialize();

        for (int i = 0; i < commandSize && !wonRace; i++) {
            move(reader.readLine());
        }

        printResult();
    }

    private static void printResult() {
        field[row][col] = 'P';

        System.out.println(wonRace ?
                "Well done, the player won first place!" :
                "Oh no, the player got lost on the track!");

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(field[i]).replaceAll("[\\[\\], ]",""));
        }
    }
    private static void move(String direction) {
        switch (direction) {
            case "up": row--; break;
            case "down": row++; break;
            case "left": col--; break;
            case "right": col++; break;
        }

        checkPosition(direction);
    }
    private static void checkPosition(String lastDirection) {
        assertCorrectPosition();

        if (field[row][col] == 'B') {
            move(lastDirection);
        } else if (field[row][col] == 'T') {
            String backDirection = "";

            switch (lastDirection) {
                case "up": backDirection = "down"; break;
                case "down": backDirection = "up"; break;
                case "left": backDirection = "right"; break;
                case "right": backDirection = "left"; break;
            }

            move(backDirection);
        } else if (field[row][col] == 'F') {
            wonRace = true;
        }
    }
    private static void assertCorrectPosition() {
        if (row < 0) {
            row = size - 1;
        }

        if (col < 0) {
            col = size - 1;
        }

        if (row == size) {
            row = 0;
        }

        if (col == size) {
            col = 0;
        }
    }
    private static void initialize() throws IOException {
        size = Integer.parseInt(reader.readLine());
        commandSize = Integer.parseInt(reader.readLine());

        field = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = reader.readLine();

            if (line.contains("P")) {
                row = i;
                for (int j = 0; j < size; j++) {
                    if (line.charAt(j) == 'P') {
                        col = j;
                        break;
                    }
                }
            }

            field[i] = line.replaceAll("P",".").toCharArray();
        }
    }
}