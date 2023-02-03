import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_2_Bomb {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static char[][] matrix;
    static int size;
    static int row;
    static int col;
    static String[] moves;
    static int disabledBombs;
    static int totalBombs;
    static boolean hasFinished;
    public static void main(String[] args) throws IOException {
        initialize();

        for (int i = 0; i < moves.length && !hasFinished && (disabledBombs < totalBombs); i++) {
            executeMove(moves[i]);
        }

        printResult();
    }
    private static void printResult(){
        if (disabledBombs == totalBombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (hasFinished){
            System.out.printf("END! %d bombs left on the field", (totalBombs - disabledBombs));
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", (totalBombs - disabledBombs), row, col);
        }
    }
    private static void executeMove(String direction){
        switch (direction){
            case "up": if (row-1 >= 0)
                    row--;
                break;
            case "down": if (row+1 < size)
                    row++;
                break;
            case "left": if (col-1 >= 0)
                    col--;
                break;
            case "right": if (col+1 < size)
                    col++;
                break;
        }

        checkCurrentPosition();
    }
    private static void checkCurrentPosition(){
        switch (matrix[row][col]) {
            case 'B':
                matrix[row][col] = '+';
                disabledBombs++;
                System.out.println("You found a bomb!");
                break;
            case 'e':
                hasFinished = true;
                break;
        }
    }
    private static void initialize() throws IOException {
        size = Integer.parseInt(reader.readLine());
        moves = reader.readLine().split(",");

        matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = reader.readLine().replaceAll("\\s","");

            for (int j = 0; j < line.length(); j++) {
                char curr = line.charAt(j);
                if (curr == 's') {
                    row = i;
                    col = j;
                } else if (curr == 'B') {
                    totalBombs++;
                }
            }

            matrix[i] = line.toCharArray();
        }
    }
}