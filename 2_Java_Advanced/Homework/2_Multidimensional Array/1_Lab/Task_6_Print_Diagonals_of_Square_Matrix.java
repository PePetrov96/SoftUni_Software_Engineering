import java.util.Arrays;
import java.util.Scanner;

public class Task_6_Print_Diagonals_of_Square_Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split("\\s+");
        }

        String[][] result = new String[2][matrix[0].length];

        for (int rows = 0; rows < matrix.length; rows++) {
            result[0][rows] = matrix[rows][rows];
            result[1][rows] = matrix[matrix.length-1-rows][rows];
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(result[i]).replaceAll("[\\[\\],]", ""));
        }
    }
}