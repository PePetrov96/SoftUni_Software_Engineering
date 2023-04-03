import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task_5_Paths_in_Labyrinth {
    public static List<Character> path = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        char[][] labyrinth = getLabyrinth(rows, cols, reader);

        findPaths(0, 0, 'S', labyrinth);
    }

    public static void findPaths(int row, int col, char direction, char[][] labyrinth) {
        if (!isInBounds(row, col, labyrinth)) {
            return;
        }

        path.add(direction);

        if (isExit(row, col, labyrinth)) {
            printPath();
        } else if (isFree(row, col, labyrinth)) {
            mark(row, col, labyrinth);
            findPaths(row, col + 1, 'R', labyrinth);
            findPaths(row + 1, col, 'D', labyrinth);
            findPaths(row, col - 1, 'L', labyrinth);
            findPaths(row - 1, col, 'U', labyrinth);
            unMark(row, col, labyrinth);
        }

        path.remove(path.size() - 1);
    }

    private static boolean isInBounds(int row, int col, char[][] labyrinth) {
        return row >= 0 && row < labyrinth.length && col >= 0 && col < labyrinth[0].length;
    }

    private static boolean isExit(int row, int col, char[][] labyrinth) {
        return labyrinth[row][col] == 'e';
    }

    private static boolean isFree(int row, int col, char[][] labyrinth) {
        return labyrinth[row][col] == '-';
    }

    private static void mark(int row, int col, char[][] labyrinth) {
        labyrinth[row][col] = 'v';
    }

    private static void unMark(int row, int col, char[][] labyrinth) {
        labyrinth[row][col] = '-';
    }

    public static void printPath() {
        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static char[][] getLabyrinth(int rows, int cols, BufferedReader reader) throws IOException {
        char[][] out = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            out[i] = reader.readLine().toCharArray();
        }

        return out;
    }
}
