import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Mouse_and_Cheese {
    static char[][] territory;
    static byte size;
    static byte row;
    static byte col;
    static byte eatenCheese;
    static boolean isOut;
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        initialize();

        String input;
        while (!"end".equals(input = reader.readLine()) && !isOut) {
            move(input);
        }

        printResult();
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

        checkPosition(direction);
    }

    private static void checkPosition(String lastMove) {
        if (row < 0 || col < 0 || row >= size || col >= size) {
            isOut = true;
            return;
        }

        char curr = territory[row][col];

        if (curr == 'c') {
            territory[row][col] = '-';
            eatenCheese++;
        } else if (curr == 'B') {
            territory[row][col] = '-';
            move(lastMove);
        }
    }

    private static void printResult() {
        if (isOut) {
            System.out.println("Where is the mouse?");
        } else {
            territory[row][col] = 'M';
        }

        System.out.println(eatenCheese >= 5 ?
                String.format("Great job, the mouse is fed %d cheeses!", eatenCheese) :
                String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.", (5 - eatenCheese)));

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(territory[i]).replaceAll("[\\[\\], ]",""));
        }
    }

    private static void initialize() throws IOException {
        size = Byte.parseByte(reader.readLine());
        territory = new char[size][size];

        for (byte i = 0; i < size; i++) {
            String line = reader.readLine();

            if (line.contains("M")) {
                row = i;
                for (byte j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == 'M') {
                        col = j;
                        break;
                    }
                }
            }

            territory[i] = line.replaceAll("M","-").toCharArray();
        }
    }
}