import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_6_Queens_Puzzle {
    private static final int BOARD_SIZE = 8;
    private static final int[] QUEEN_PERMUTATION = {0, 1, 2, 3, 4, 5, 6, 7};
    private static List<int[]> solutions = new ArrayList<>();

    public static void main(String[] args) {
        permute(QUEEN_PERMUTATION, 0);
        for (int[] solution : solutions) {
            printBoard(solution);
            System.out.println();
        }
    }

    private static void permute(int[] queens, int start) {
        if (start == BOARD_SIZE) {
            if (isValidPlacement(queens)) {
                solutions.add(Arrays.copyOf(queens, BOARD_SIZE));
            }
        } else {
            for (int i = start; i < BOARD_SIZE; i++) {
                swap(queens, start, i);
                permute(queens, start + 1);
                swap(queens, start, i);
            }
        }
    }

    private static boolean isValidPlacement(int[] queens) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = i + 1; j < BOARD_SIZE; j++) {
                if (queens[i] == queens[j] || Math.abs(queens[i] - queens[j]) == j - i) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printBoard(int[] queens) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (queens[i] == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
