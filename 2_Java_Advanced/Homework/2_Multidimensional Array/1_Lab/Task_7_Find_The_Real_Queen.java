import java.util.Scanner;

public class Task_7_Find_The_Real_Queen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String[] input = scan.nextLine().split("\\s+");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = input[j].charAt(0);
            }
        }

        boolean found = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] == 'q') {
                    if (checkValidity(matrix, i, j)) {
                        System.out.println(i + " " + j);
                        found = true; break;
                    }
                }
            }
            if (found) break;
        }

    }
    private static boolean checkValidity (char[][] matrix, int row, int column) {
        for (int i = 0; i < 8; i++) if (matrix[row][i] == 'q' && i != column) return false; //Horizontal check

        for (int i = 0; i < 8; i++) if (matrix[i][column] == 'q' && i != row) return false; //Vertical check

        int checkColumn = column - 1;
        for (int i = row - 1; i >= 0 && checkColumn >= 0; i--, checkColumn--) { // UpLeftDiagonal check
            if (matrix[i][checkColumn] == 'q') return false;
        }

        checkColumn = column + 1;
        for (int i = row + 1; i < matrix.length && checkColumn < matrix[row].length; i++, checkColumn++) { // UpRightDiagonal check
            if (matrix[i][checkColumn] == 'q') return false;
        }

        checkColumn = column - 1;
        for (int i = row + 1; i < matrix.length && checkColumn >= 0; i++, checkColumn--) { // DownLeftDiagonal check
            if (matrix[i][checkColumn] == 'q') return false;
        }

        checkColumn = column + 1;
        for (int i = row - 1; i >= 0 && checkColumn < matrix[i].length; i--, checkColumn++) { // DownRightDiagonal check
            if (matrix[i][checkColumn] == 'q') return false;
        }

        return true;
    }
}