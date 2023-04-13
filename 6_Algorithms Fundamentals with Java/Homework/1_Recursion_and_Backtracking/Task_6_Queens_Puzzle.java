public class Task_6_Queens_Puzzle {
    private static final int BOARD_SIZE = 8;
    private static int[] positions = new int[BOARD_SIZE];

    public static void main(String[] args) {
        solve(0);
    }

    private static void solve(int row) {
        if (row == BOARD_SIZE) {
            printBoard();
            return;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isValidPosition(row, col)) {
                positions[row] = col;
                solve(row + 1);
            }
        }
    }

    private static boolean isValidPosition(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (positions[i] == col ||
                    positions[i] - i == col - row ||
                    positions[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == positions[i]) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}