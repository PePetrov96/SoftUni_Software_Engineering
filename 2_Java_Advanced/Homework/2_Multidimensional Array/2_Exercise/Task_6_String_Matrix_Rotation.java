import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_6_String_Matrix_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        ArrayList<String> input = new ArrayList<>();

        int counter = getInputAndCounter(scanner, command, input);

        String rotationCommand = input.get(0);

        int degrees = getDegrees(rotationCommand);

        input.remove(0);

        int length = getMatrixLength(input);

        char[][] matrix = getMatrix(input, counter, length);


        if (degrees == 90) {
            oneRotation(input, length, matrix);
        } else if (degrees == 0) {
            print(input, length, matrix);
        } else if (degrees == 180) {
            twoRotations(input, counter, length, matrix);
        } else if (degrees == 270) {
            threeRotations(input, length, matrix);
        }
    }

    private static int getDegrees(String rotationCommand) {
        String regex = "([A-Za-z]+)(\\()([0-9]+)(\\))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rotationCommand);

        boolean matches = matcher.matches();

        int degrees = Integer.parseInt(matcher.group(3));

        while (degrees >= 360){
            degrees = degrees % 360;
        }
        return degrees;
    }

    private static void threeRotations(ArrayList<String> list, int length, char[][] matrix) {
        char[][] newMatrix = new char[length][list.size()];
        int i = 0;
        for (int c = 0; c < newMatrix[list.size()].length; c++) {
            int j = 0;
            for (int r = newMatrix.length - 1; r >= 0; r--) {
                if (j < matrix[i].length) {
                    newMatrix[r][c] = matrix[i][j];
                }
                j++;
            }
            i++;
        }
        print(list, length, newMatrix);
    }

    private static void twoRotations(ArrayList<String> list, int counter, int length, char[][] matrix) {
        char[][] newMatrix = new char[counter][length];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = matrix[r].length - 1; c >= 0; c--) {
                newMatrix[matrix.length - 1 - r][c] = matrix[r][matrix[r].length - 1 - c];
            }
        }
        print(list, length, newMatrix);
    }

    private static void print(ArrayList<String> list, int length, char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) { // You missed this condition!!!!!!!!!!!!!!!!!!!!!
                    matrix[r][c] = ' ';
                }
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void oneRotation(ArrayList<String> list, int length, char[][] matrix) {
        char[][] newMatrix = new char[length][list.size()];
        int i = 0;
        for (int c = matrix.length - 1; c >= 0; c--) {
            int j = 0;
            for (int r = 0; r < matrix[i].length; r++) {
                newMatrix[r][c] = matrix[i][j];
                j++;
            }
            i++;
        }
        print(list, length, newMatrix);
    }

    private static char[][] getMatrix(ArrayList<String> list, int counter, int length) {
        char[][] matrix = new char[counter][length];
        for (int r = 0; r < matrix.length; r++) {
            char[] arr = list.get(r).toCharArray();
            matrix[r] = arr;
        }
        return matrix;
    }

    private static int getMatrixLength(ArrayList<String> list) {
        int max = Integer.MIN_VALUE;
        for (String s : list) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    private static int getInputAndCounter(Scanner scanner, String command, ArrayList<String> list) {
        int counter = 0;
        while (!command.equalsIgnoreCase("END")) {
            list.add(command);
            command = scanner.nextLine();
            counter++;
        }
        return counter - 1;
    }
}