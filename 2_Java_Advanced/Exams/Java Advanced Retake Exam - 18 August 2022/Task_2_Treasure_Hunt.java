import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_2_Treasure_Hunt {
    static char[][] matrix;
    static int rowSize;
    static int colSize;
    static int row;
    static int col;
    static List<String> path;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        rowSize = size[0];
        colSize = size[1];

        path = new ArrayList<>();

        matrix = returnMatrix(reader);

        String input;
        while (!"Finish".equals(input = reader.readLine())) {
            move(input);
        }

        printResult();
    }
    private static void printResult() {
        if (matrix[row][col] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }

    }
    private static void move(String direction) {
        switch (direction) {
            case "up":
                if (row - 1 >= 0) {
                    if (matrix[row-1][col] != 'T') {
                        row--;
                        path.add(direction);}
                }
                break;
            case "down":
                if (row + 1 < rowSize) {
                    if (matrix[row+1][col] != 'T') {
                        row++;
                        path.add(direction);
                    }
                }
                break;
            case "left":
                if (col - 1 >= 0) {
                    if (matrix[row][col-1] != 'T') {
                        col--;
                        path.add(direction);
                    }
                }
                break;
            case "right":
                if (col + 1 < colSize) {
                    if (matrix[row][col+1] != 'T') {
                        col++;
                        path.add(direction);
                    }
                }
                break;
        }
    }
    private static char[][] returnMatrix(BufferedReader reader) throws IOException {
        char[][] result = new char[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            String line = reader.readLine();

            if (line.contains("Y")) {
                row = i;
                col = getCol(line.replaceAll(" ", ""));
            }

            result[i] = line
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        return result;
    }
    private static int getCol(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'Y') {
                return i;
            }
        }
        return 0;
    }
}