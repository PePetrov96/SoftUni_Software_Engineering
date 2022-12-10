import java.util.Arrays;
import java.util.Scanner;

public class Task_3_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(diagonalDiff(matrix));
    }
    private static int diagonalDiff (int[][] matrix) {
        int sumLeft = 0;
        int sumRight = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            sumLeft += matrix[rows][rows];
            sumRight += matrix[rows][matrix.length - 1 - rows];
        }

        return Math.abs(sumLeft - sumRight);
    }
}