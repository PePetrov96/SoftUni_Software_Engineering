import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Task_3_Intersection_of_Two_Matrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int columns = Integer.parseInt(scan.nextLine());

        String[][] firstMatrix = new String[rows][columns];
        String[][] resultMatrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            firstMatrix[i] = scan.nextLine().split("\\s+");
        }

        for (int i = 0; i < rows; i++) {
            String[] row = scan.nextLine().split("\\s+");
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (Objects.equals(firstMatrix[i][j], row[j])) {
                    resultMatrix[i][j] = row[j];
                } else {
                    resultMatrix[i][j] = "*";
                }
            }
        }

        for (String[] matrix : resultMatrix) {
            System.out.println(Arrays.toString(matrix).replaceAll("[\\[\\],]", ""));
        }
    }
}