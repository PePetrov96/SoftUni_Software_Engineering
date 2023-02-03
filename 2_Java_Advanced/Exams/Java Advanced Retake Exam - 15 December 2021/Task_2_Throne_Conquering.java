import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Throne_Conquering {
    static int energy;
    static byte size;
    static char[][] field;
    static byte helenRow;
    static byte helenCol;
    static byte parisRow;
    static byte parisCol;
    static boolean foundHelen = false;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        initialize();

        while (energy > 0 && !foundHelen) {
            String[] command = reader.readLine().trim().split("\\s");
            move(command[0], Byte.parseByte(command[1]), Byte.parseByte(command[2]));
        }

        printResult();
    }

    private static void printResult() {
        if (foundHelen) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
            field[helenRow][helenCol] = '-';
            field[parisRow][parisCol] = '-';
        } else {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(field[i]).replaceAll("[\\[\\], ]",""));
        }
    }
    private static void move(String direction, byte toRow, byte toCol) {
        field[toRow][toCol] = 'S';

        switch (direction) {
            case "up":
                if (parisRow-1 >= 0) {
                    parisRow--;
                }
                break;
            case "down":
                if (parisRow+1 < size) {
                    parisRow++;
                }
                break;
            case "left":
                if (parisCol-1 >= 0) {
                    parisCol--;
                }
                break;
            case "right":
                if (parisCol+1 < size) {
                    parisCol++;
                }
                break;
        }

        energy--;

        if (parisRow == helenRow && parisCol == helenCol) {
            foundHelen = true;
            return;
        }

        if (field[parisRow][parisCol] == 'S') {
            if (energy >= 2) {
                field[parisRow][parisCol] = '-';
            }
            energy -= 2;
        }
    }
    private static void initialize() throws IOException {
        energy = Integer.parseInt(reader.readLine());
        size = Byte.parseByte(reader.readLine());
        field = new char[size][size];

        for (byte i = 0; i < size; i++) {
            String line = reader.readLine();

            if (line.contains("H") || line.contains("P")) {
                for (byte j = 0; j < line.length(); j++) {
                    char curr = line.charAt(j);

                    if (curr == 'H') {
                        helenRow = i;
                        helenCol = j;
                    } else if (curr == 'P') {
                        parisRow = i;
                        parisCol = j;
                    }
                }
            }

            field[i] = line.replaceAll("P","-").toCharArray();
        }
    }
}