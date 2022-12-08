import java.util.Arrays;
import java.util.Scanner;

public class Task_8_Wrong_Measurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++)
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int measurement = matrix[input[0]][input[1]];

        int[][] resultMatrix = result(matrix, measurement);

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(resultMatrix[i]).replaceAll("[\\[\\],]", ""));
        }
    }
    private static int[][] result (int[][] matrix, int measurement) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == measurement) {
                    result[rows][cols] = newNum(matrix, rows, cols, measurement);
                } else {
                    result[rows][cols] = matrix[rows][cols];
                }
            }
        }
        return result;
    }

    private static int newNum (int[][] matrix, int row, int column, int target) {
        int sum = 0;

        try { //up
            if (matrix[row-1][column] != target) sum += matrix[row-1][column];
        } catch (IndexOutOfBoundsException ignore) {}

        try { //down
            if (matrix[row+1][column] != target) sum += matrix[row+1][column];
        } catch (IndexOutOfBoundsException ignore) {}

        try { //left
            if (matrix[row][column-1] != target) sum += matrix[row][column-1];
        } catch (IndexOutOfBoundsException ignore) {}

        try { //right
            if (matrix[row][column+1] != target) sum += matrix[row][column+1];
        } catch (IndexOutOfBoundsException ignore) {}

        return sum;
    }
}