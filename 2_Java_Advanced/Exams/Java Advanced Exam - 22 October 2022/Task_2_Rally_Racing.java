import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Rally_Racing {
    static char[][] matrix;
    static byte size;
    static int kmCovered = 0;
    static byte carRow = 0;
    static byte carCol = 0;
    static String carName;
    static byte tunnelOneRow;
    static byte tunnelOneCol;
    static byte tunnelTwoRow;
    static byte tunnelTwoCol;
    static byte finishRow;
    static byte finishCol;
    static boolean finished = false;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        size = Byte.parseByte(reader.readLine());
        carName = reader.readLine();

        matrix = new char[size][size];
        getMatrix();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            if (!finished) {
                moveCar(input);
            }
        }

        printResult();
    }

    private static void printResult() {
        matrix[carRow][carCol] = 'C';

        if (finished) {
            System.out.printf("Racing car %s finished the stage!%n", carName);
        } else {
            System.out.printf("Racing car %s DNF.%n", carName);
        }

        System.out.printf("Distance covered %d km.%n", kmCovered);

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(matrix[i]).replaceAll("[\\[\\], ]", ""));
        }

    }
    private static void moveCar(String direction) {
        switch (direction) {
            case "up": carRow--; break;
            case "down": carRow++; break;
            case "left": carCol--; break;
            case "right": carCol++; break;
        }

        kmCovered += 10;

        checkPosition();
    }
    private static void checkPosition() {
        if (finishRow == carRow && finishCol == carCol) {
            finished = true;
            return;
        }

        if (tunnelOneRow == carRow && tunnelOneCol == carCol) {
            matrix[tunnelOneRow][tunnelOneCol] = '.';
            matrix[tunnelTwoRow][tunnelTwoCol] = '.';

            carRow = tunnelTwoRow;
            carCol = tunnelTwoCol;
            kmCovered += 20;

        } else if (tunnelTwoRow == carRow && tunnelTwoCol == carCol) {
            matrix[tunnelOneRow][tunnelOneCol] = '.';
            matrix[tunnelTwoRow][tunnelTwoCol] = '.';

            carRow = tunnelOneRow;
            carCol = tunnelOneCol;
            kmCovered += 20;
        }


    }
    private static void getMatrix() throws IOException {
        boolean foundFirst = false;

        for (byte i = 0; i < size; i++) {
            String[] line = reader.readLine().split("\\s");

            for (byte j = 0; j < size; j++) {
                char curr = line[j].charAt(0);

                if (curr == '.') {
                    matrix[i][j] = curr;

                } else if (curr == 'T') {
                    if (!foundFirst) {
                        tunnelOneRow = i;
                        tunnelOneCol = j;
                        foundFirst = true;
                    } else {
                        tunnelTwoRow = i;
                        tunnelTwoCol = j;
                    }

                    matrix[i][j] = curr;
                } else if (curr == 'F') {
                    finishRow = i;
                    finishCol = j;
                    matrix[i][j] = curr;
                }
            }
        }
    }
}