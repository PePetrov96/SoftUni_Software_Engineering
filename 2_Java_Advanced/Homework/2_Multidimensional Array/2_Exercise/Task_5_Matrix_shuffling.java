import java.util.Arrays;
import java.util.Scanner;

public class Task_5_Matrix_shuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] n = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[n[0]][n[1]];
        for (int i = 0; i < n[0]; i++) matrix[i] = scan.nextLine().split("\\s+");

        String input;

        while (!"END".equals(input = scan.nextLine())) {
            modifyMatrix(matrix, input.split("\\s+"));
        }
    }
    private static void modifyMatrix (String[][] matrix, String[] commands) {
        if (commands[0].equals("swap") && commands.length == 5) {
            try {
                int row1; int col1; int row2; int col2;

                try {
                    row1 = Integer.parseInt(commands[1]);
                    col1 = Integer.parseInt(commands[2]);
                    row2 = Integer.parseInt(commands[3]);
                    col2 = Integer.parseInt(commands[4]);
                } catch (NumberFormatException b) {
                    System.out.println("Invalid input!");
                    return;
                }

                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;

                Arrays.stream(matrix).forEach((i) -> {
                    Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
                    System.out.println();
                });

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid input!");
            }
        } else {
            System.out.println("Invalid input!");
        }
    }
}
