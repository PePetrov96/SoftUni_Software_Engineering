import java.util.Arrays;
import java.util.Scanner;

public class Task_2_Matrix_of_Palindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        String[][] result = outputMatrix(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

        for (String[] strings : result) System.out.println(Arrays.toString(strings).replaceAll("[\\[\\],]", ""));
    }
    private static String[][] outputMatrix (int Rows, int Columns) {
        String[][] result = new String[Rows][Columns];

        char current = 'a';

        for (int rows = 0; rows < Rows; rows++) {

            for (int columns = 0; columns < Columns; columns++) {

                result[rows][columns] = "".concat(String.valueOf(current))
                        .concat(String.valueOf((char) (current + columns)))
                        .concat(String.valueOf(current));
            }

            current++;
        }

        return result;
    }
}
