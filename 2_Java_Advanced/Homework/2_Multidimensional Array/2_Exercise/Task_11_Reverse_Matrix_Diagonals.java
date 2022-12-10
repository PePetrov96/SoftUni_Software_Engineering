import java.util.Arrays;
import java.util.Scanner;

public class Task_11_Reverse_Matrix_Diagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] matrixRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = matrixRow;
        }

        for (int col = cols - 1; col >= 0; col--) {
            int printRow = rows;
            for (int printCol = col; printCol <= cols - 1 && printRow > 0; printCol++) {
                System.out.print(matrix[printRow - 1][printCol] + " ");
                printRow--;
            }
            System.out.println();
        }

        if(rows >= 2) {
            for (int row = rows - 2; row >= 0; row--) {
                int printRow = row;
                for (int col = 0; col <= row && col < cols; col++) {
                    System.out.print(matrix[printRow][col] + " ");
                    printRow--;
                }
                System.out.println();
            }
        }
    }
}