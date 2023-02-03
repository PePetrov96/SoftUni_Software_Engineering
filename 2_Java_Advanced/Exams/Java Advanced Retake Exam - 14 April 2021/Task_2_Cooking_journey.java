import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Cooking_journey {
    static byte size;
    static char[][] bakery;
    static byte row;
    static byte col;
    static byte pillarOneRow;
    static byte pillarOneCol;
    static byte pillarTwoRow;
    static byte pillarTwoCol;
    static boolean foundPillar;
    static boolean isOut = false;
    static int money;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        initialize();

        while (!isOut && money < 50) {
            move(reader.readLine());
        }

        print_Result();

    }
    private static void print_Result() {
        if (!isOut) {
            bakery[row][col] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }

        System.out.printf("Money: %d%n", money);

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(bakery[i]).replaceAll("[\\[\\], ]", ""));
        }
    }

    private static void move(String direction) {
        switch (direction) {
            case "up": row--;
                break;
            case "down": row++;
                break;
            case "left": col--;
                break;
            case "right": col++;
                break;
        }

        if (check_If_Within_Bakery()) {
            check_Position();
        } else {
            isOut = true;
        }
    }

    private static void check_Position() {
        char current = bakery[row][col];

        if (Character.isDigit(current)) {
            money += Integer.parseInt(String.valueOf(current));
            bakery[row][col] = '-';
        } else if (current == 'P') {
            if (row == pillarOneRow && col == pillarOneCol) {
                row = pillarTwoRow;
                col = pillarTwoCol;
            } else {
                row = pillarOneRow;
                col = pillarOneCol;
            }
            bakery[pillarOneRow][pillarOneCol] = '-';
            bakery[pillarTwoRow][pillarTwoCol] = '-';
        }
    }

    private static boolean check_If_Within_Bakery() {
        return row >= 0 && col >= 0 && row < size && col < size;
    }

    private static void initialize() throws IOException {
        size = Byte.parseByte(reader.readLine());

        bakery = new char[size][size];

        for (byte i = 0; i < size; i++) {
            String line = reader.readLine();

            if (line.contains("S") || line.contains("P")) {
                find_Positions(i, line);
            }

            bakery[i] = line.replace("S", "-").toCharArray();
        }
    }

    private static void find_Positions(byte currRow, String line) {
        for (byte i = 0; i < size; i++) {
            if (line.charAt(i) == 'S') {
                row = currRow;
                col = i;
            } else if (line.charAt(i) == 'P') {
                if (!foundPillar) {
                    pillarOneRow = currRow;
                    pillarOneCol = i;
                    foundPillar = true;
                } else {
                    pillarTwoRow = currRow;
                    pillarTwoCol = i;
                }
            }
        }
    }
}