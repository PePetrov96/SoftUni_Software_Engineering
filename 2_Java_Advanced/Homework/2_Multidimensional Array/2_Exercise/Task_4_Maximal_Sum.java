import java.util.Arrays;
import java.util.Scanner;

public class Task_4_Maximal_Sum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] n = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[n[0]][n[1]];

        for (int i = 0; i < n[0]; i++) matrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] bestMatrix = returnMatrix(matrix);

        System.out.println("Sum = " + Arrays.stream(bestMatrix)
                .mapToInt(arr -> Arrays.stream(arr).sum())
                .sum());

        Arrays.stream(bestMatrix).forEach((i) -> {
            Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
            System.out.println();
        });
    }
    private static int[][] returnMatrix (int[][] matrix) {
        int[][] result = new int[3][3];
        int best = Integer.MIN_VALUE;


        for (int rows = 0; rows < matrix.length-2; rows++) {
            for (int columns = 0; columns < matrix[rows].length-2; columns++) {
                int[][] temporary = new int[3][3];

                for (int subRows = 0; subRows < 3; subRows++) {
                    System.arraycopy(matrix[rows + subRows], columns, temporary[subRows], 0, 3);
                }

                int sum = Arrays.stream(temporary)
                        .mapToInt(arr -> Arrays.stream(arr).sum())
                        .sum();

                if (sum > best) {
                    best = sum;
                    result = temporary;
                }
            }
        }

        return result;
    }
}