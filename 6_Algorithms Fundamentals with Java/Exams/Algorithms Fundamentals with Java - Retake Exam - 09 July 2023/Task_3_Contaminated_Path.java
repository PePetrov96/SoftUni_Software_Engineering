import java.util.*;

public class Task_3_Contaminated_Path {
    private static int maxFertility;
    private static List<int[]> bestPath;

    public static void main(String[] args) {
        // Read input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] cells = line.split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(cells[j]);
            }
        }

        String contaminatedLine = scanner.nextLine();
        String[] contaminatedCells = contaminatedLine.split(" ");
        Set<String> contaminatedSet = new HashSet<>(Arrays.asList(contaminatedCells));

        maxFertility = Integer.MIN_VALUE;
        bestPath = new ArrayList<>();

        findOptimalPath(grid, contaminatedSet, 0, 0, 0, new ArrayList<>());

        // Print the result
        System.out.println("Max total fertility: " + maxFertility);
        System.out.print("[");
        for (int i = 0; i < bestPath.size(); i++) {
            int[] cell = bestPath.get(i);
            System.out.print("(" + cell[0] + ", " + cell[1] + ")");
            if (i < bestPath.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    private static void findOptimalPath(int[][] grid, Set<String> contaminatedSet, int row, int col, int fertility, List<int[]> currentPath) {
        int n = grid.length;

        if (row >= n || col >= n || contaminatedSet.contains(row + "," + col)) {
            return;
        }

        fertility += grid[row][col];
        currentPath.add(new int[]{row, col});

        if (row == n - 1 && col == n - 1) {
            if (fertility > maxFertility) {
                maxFertility = fertility;
                bestPath = new ArrayList<>(currentPath);
            }
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        findOptimalPath(grid, contaminatedSet, row + 1, col, fertility, currentPath); // Move downwards
        findOptimalPath(grid, contaminatedSet, row, col + 1, fertility, currentPath); // Move rightwards

        currentPath.remove(currentPath.size() - 1);
    }
}
