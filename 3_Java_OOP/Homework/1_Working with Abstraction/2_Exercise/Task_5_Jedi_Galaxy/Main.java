import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long sum = 0;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        matrix = getMatrix(dimensions);

        String command;

        while (!"Let the Force be with you".equals(command = scanner.nextLine())) {
            int[] hero = Arrays.stream(command.split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] evil = Arrays.stream(scanner.nextLine().split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            moveEvil(evil);

            moveHero(hero);

        }

        System.out.println(sum);
    }

    private static void moveHero (int[] hero) {
        int row = hero[0];
        int col = hero[1];

        getHeroInRange(row, col);

        while (isInRange(row, col)) {
            sum += matrix[row--][col++];
        }
    }
    private static void moveEvil (int[] evil) {
        int row = evil[0];
        int col = evil[1];

        getEvilInRange(row, col);

        while (isInRange(row, col)) {
            matrix[row--][col--] = 0;
        }
    }

    private static boolean isInRange(int row, int col) {
        return row >= 0 && col >= 0 &&
                row < matrix.length && col < matrix[0].length;
    }

    private static void getHeroInRange(int row, int col) {
        while (!isInRange(row, col)) {
            col++;
            row--;
        }
    }
    private static void getEvilInRange(int row, int col) {
        while (!isInRange(row, col)) {
            col--;
            row--;
        }
    }
    private static int[][] getMatrix(int[] dimensions) {
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] result = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = value++;
            }
        }

        return result;
    }
}
