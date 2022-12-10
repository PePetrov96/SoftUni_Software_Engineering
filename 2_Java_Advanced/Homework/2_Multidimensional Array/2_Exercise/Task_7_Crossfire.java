import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task_7_Crossfire {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner (System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> matrix = new ArrayList<>();
        createMatrix(matrix, dimensions[0], dimensions[1]);

        String line;
        while (!"Nuke it from orbit".equals(line = scan.nextLine())){
            modify(matrix, line.split("\\s+"));
        }

        matrix.forEach((i) -> System.out.println(i.toString().replaceAll("[\\[\\],]","")));

    }
    private static void createMatrix (List<List<Integer>> matrix, int rows, int cols) {
        int count = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(count++);
            }
        }
    }
    private static void modify (List<List<Integer>> matrix, String[] data) {
        int row = Integer.parseInt(data[0]);
        int col = Integer.parseInt(data[1]);
        int radius = Integer.parseInt(data[2]);

        for (int i = row - radius; i <= row + radius; i++) {
            if (isInRange(i, col, matrix) && i != row) matrix.get(i).remove(col);
        }

        for (int i = col + radius; i >= col - radius; i--) {
            if (isInRange(row, i, matrix)) matrix.get(row).remove(i);
        }

        matrix.removeIf(List::isEmpty);
    }
    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}