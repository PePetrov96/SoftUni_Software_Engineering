import java.util.Arrays;
import java.util.Scanner;

public class Task_1_Compare_Matrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int[][] firstMatrix = returnArraySize(scan.nextLine());
        for (int i = 0; i < firstMatrix.length; i++) {
            firstMatrix[i] = addRow(scan.nextLine());
        }

        int[][] secondMatrix = returnArraySize(scan.nextLine());
        for (int j = 0; j < secondMatrix.length; j++) {
            secondMatrix[j] = addRow(scan.nextLine());
        }

        System.out.println(compareMatrices(firstMatrix, secondMatrix) ? "equal" : "not equal");
    }
    private static int[] addRow (String input) {
        return Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
    public static int[][] returnArraySize (String input) {
        int[] dimensions = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int first = dimensions[0]; int second = dimensions[1];
        return new int[first][second];
    }

    private static boolean compareMatrices (int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) return false;

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) return false;

            for (int column = 0; column < firstMatrix[row].length; column++) {
                if (firstMatrix[row][column] != secondMatrix[row][column]) return false;
            }

        }

        return true;
    }
}