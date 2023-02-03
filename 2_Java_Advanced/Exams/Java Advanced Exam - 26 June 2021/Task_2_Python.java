import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_2_Python {
    public static char[][] matrix;
    public static int row;
    public static int col;
    public static int food = 0;
    public static boolean hitEnemy = false;

    public static int snakeSize = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());

        String[] commands = reader.readLine().split(",\\s+");
        matrix = readMatrix(rows, reader);

        for (String command : commands) {
            move(command);
            if (hitEnemy) {
                break;
            }
            if (food == 0) {
                break;
            }
        }

        if (hitEnemy) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (food != 0) {
            System.out.println("You lose! There is still " + food + " food to be eaten.");
        } else {
            System.out.println("You win! Final python length is " + snakeSize);
        }
    }

    public static void move(String command) {
        int size = matrix.length-1;

        switch (command) {
            case "up":
                if (row == 0) {
                    row = size;
                } else {
                    row--;
                }
                break;
            case "down":
                if (row == size) {
                    row = 0;
                } else {
                    row++;
                }
                break;
            case "left":
                if (col == 0) {
                    col = size;
                } else {
                    col--;
                }
                break;
            case "right":
                if (col == size) {
                    col = 0;
                } else {
                    col++;
                }
                break;
        }

        if (matrix[row][col] == 'f') {
            food--; snakeSize++;
            matrix[row][col] = '*';
        } else if (matrix[row][col] == 'e') {
            hitEnemy = true;
        }
    }

    public static char[][] readMatrix(int rows, BufferedReader reader) throws IOException {
        char[][] matrix = new char[rows][rows];

        for (int i = 0; i < matrix.length; i++) {
            String[] colData = reader.readLine().split(" ");

            for (int j = 0; j < colData.length; j++) {
                char curr = colData[j].charAt(0);

                matrix[i][j] = curr;

                if (curr == 's') {
                    row = i;
                    col = j;
                } else if (curr == 'f') {
                    food++;
                }
            }
        }
        return matrix;
    }
}