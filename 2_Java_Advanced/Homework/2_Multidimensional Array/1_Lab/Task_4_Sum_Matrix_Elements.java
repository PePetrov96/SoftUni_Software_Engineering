import java.util.Arrays;
import java.util.Scanner;

public class Task_4_Sum_Matrix_Elements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = returnArraySize(scan.nextLine());
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int sum = Arrays.stream(matrix)
                .mapToInt(arr -> Arrays.stream(arr).sum())
                .sum();

        System.out.println(sum);
    }
    public static int[][] returnArraySize (String input) {
        int[] dimensions = Arrays.stream(input.split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int first = dimensions[0]; int second = dimensions[1];
        return new int[first][second];
    }
}