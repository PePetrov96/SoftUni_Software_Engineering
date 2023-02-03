import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Armory {
    static char[][] armory;
    static byte size;
    static byte row;
    static byte col;
    static int profit = 0;
    static byte mirrorOneRow;
    static byte mirrorOneCol;
    static byte mirrorTwoRow;
    static byte mirrorTwoCol;
    static boolean foundMirror;
    static boolean isInArmory = true;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        initialize();

        while (profit < 66 && isInArmory) {
            move(reader.readLine());
        }

        printResult();
    }

    private static void printResult() {
        if (!isInArmory) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
            armory[row][col] = 'A';
        }

        System.out.printf("The king paid %d gold coins.%n", profit);

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(armory[i]).replaceAll("[\\[\\], ]",""));
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

        isInArmory = (row >= 0 && col >= 0 && row < size && col < size);

        if (isInArmory) {
            positionCheck();
        }
    }
    private static void positionCheck() {
        char curr = armory[row][col];

        if (Character.isDigit(curr)) {
            profit += Integer.parseInt(String.valueOf(curr));
        } else if (curr == 'M') {
            if (row == mirrorOneRow && col == mirrorOneCol) {
                armory[row][col] = '-';
                row = mirrorTwoRow; col = mirrorTwoCol;
            } else {
                armory[row][col] = '-';
                row = mirrorOneRow; col = mirrorOneCol;
            }
        }

        armory[row][col] = '-';
    }
    private static void initialize() throws IOException {
        size = Byte.parseByte(reader.readLine());

        armory = new char[size][size];

        foundMirror = false;

        for (byte i = 0; i < size; i++) {
            String line = reader.readLine().replaceAll("\\s", "");

            check(line, i);

            armory[i] = line.replaceAll("A", "-").toCharArray();
        }
    }
    private static void check(String line, byte i) {
        if (!line.contains("A") && !line.contains("M")) {
            return;
        }

        for (byte j = 0; j < size; j++) {
            char curr = line.charAt(j);

            switch (curr) {
                case 'A':
                    row = i;
                    col = j;
                    break;
                case 'M':
                    if (!foundMirror) {
                        foundMirror = true;
                        mirrorOneRow = i;
                        mirrorOneCol = j;
                    } else {
                        mirrorTwoRow = i;
                        mirrorTwoCol = j;
                    }
                    break;
            }
        }
    }
}