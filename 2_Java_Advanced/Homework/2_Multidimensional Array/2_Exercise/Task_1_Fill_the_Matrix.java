import java.util.Arrays;
import java.util.Scanner;

public class Task_1_Fill_the_Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(",\\s+");

        int[][] matrix = new int[Integer.parseInt(input[0])][];

        if (input[1].equals("A")) {
            matrix = givePatternA(Integer.parseInt(input[0]));
        } else if (input[1].equals("B")) {
            matrix = givePatternB(Integer.parseInt(input[0]));
        }

        for (int[] ints : matrix) System.out.println((Arrays.toString(ints).replaceAll("[\\[\\],]", "")));

    }
    private static int[][] givePatternA (int size) {
        int[][] result = new int[size][size];

        int count = 1;
        for (int columns = 0; columns < size; columns++) {
            for (int rows = 0; rows < size; rows++) {
                result[rows][columns] = count;
                count++;
            }
        }

        return result;
    }
    private static int[][] givePatternB (int size) {
        int[][] result = new int[size][size];

        for (int masterCols = 0; masterCols < size; masterCols++) {
            if (masterCols == 0) {
                result[0][masterCols] = 1;
            } else if (masterCols % 2 != 0) {
                result[0][masterCols] = size * (masterCols + 1);
            } else {
                result[0][masterCols] = result[0][masterCols-1] + 1;
            }
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j % 2 == 0) {
                    result[i][j] = result[i-1][j] + 1;
                } else {
                    result[i][j] = result[i-1][j] - 1;
                }
            }
        }

        return result;
    }
}