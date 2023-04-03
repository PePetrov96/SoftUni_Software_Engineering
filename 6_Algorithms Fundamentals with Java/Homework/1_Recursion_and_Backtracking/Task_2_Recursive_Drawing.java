import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_2_Recursive_Drawing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        printFigure(Integer.parseInt(reader.readLine()));
    }
    private static void printFigure(int n) {
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();

        printFigure(n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}