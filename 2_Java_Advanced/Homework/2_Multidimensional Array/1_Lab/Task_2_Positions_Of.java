import java.util.Arrays;
import java.util.Scanner;

public class Task_2_Positions_Of {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int[][] matrix = returnArraySize(scan.nextLine());

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        printResults(matrix, Integer.parseInt(scan.nextLine()));
    }
    private static void printResults (int[][] matrix, int find) {
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == find) {
                    System.out.println(row + " " + column);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
    public static int[][] returnArraySize (String input) {
        int[] dimensions = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int first = dimensions[0]; int second = dimensions[1];
        return new int[first][second];
    }
}
