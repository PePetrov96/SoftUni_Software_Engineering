import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_1_Word_Searcher {
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        // Read input
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        String wordLine = scanner.nextLine();
        String[] words = wordLine.split("\\s+");

        // Find words in the grid
        List<String> foundWords = new ArrayList<>();
        for (String word : words) {
            if (searchWord(grid, word)) {
                foundWords.add(word);
            }
        }

        // Print the found words in the order of appearance
        for (String word : words) {
            if (foundWords.contains(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean searchWord(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == word.charAt(0) && searchWordHelper(grid, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean searchWordHelper(char[][] grid, String word, int row, int col, int index, boolean[][] visited) {
        // Base case: word found
        if (index == word.length()) {
            return true;
        }

        // Check if the current cell is out of bounds or already visited
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]) {
            return false;
        }

        // Check if the current cell matches the next character in the word
        if (grid[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Recursively search in all 8 directions
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (searchWordHelper(grid, word, newRow, newCol, index + 1, visited)) {
                visited[row][col] = false; // Reset visited flag when backtracking
                return true;
            }
        }

        visited[row][col] = false; // Reset visited flag
        return false;
    }
}
