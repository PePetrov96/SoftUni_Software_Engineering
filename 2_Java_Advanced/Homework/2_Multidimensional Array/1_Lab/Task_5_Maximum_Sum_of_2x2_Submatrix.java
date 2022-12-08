import java.util.Arrays;
import java.util.Scanner;

public class Task_5_Maximum_Sum_of_2x2_Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = returnArraySize(scan.nextLine());

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] result = resultMatrix(matrix);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", ""));
        }

        System.out.println(Arrays.stream(result)
                .mapToInt(arr -> Arrays.stream(arr).sum())
                .sum());
        
    }
    private static int[][] resultMatrix (int[][] matrix) {
        int[][] result = new int[2][2];

        int max = Integer.MIN_VALUE;

        for (int rows = 1; rows < matrix.length; rows++) {
            for (int cols = 1; cols < matrix[rows].length; cols++) {
                int n = matrix[rows][cols] + matrix[rows][cols-1] + matrix[rows-1][cols] + matrix[rows-1][cols-1];
                if (n > max) {
                    max = n;
                    result[0][0] = matrix[rows-1][cols-1];
                    result[0][1] = matrix[rows-1][cols];
                    result[1][0] = matrix[rows][cols-1];
                    result[1][1] = matrix[rows][cols];
                }
            }
        }
        
        return result;
    }
    public static int[][] returnArraySize (String input) {
        int[] dimensions = Arrays.stream(input.split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int first = dimensions[0]; int second = dimensions[1];
        return new int[first][second];
    }
}