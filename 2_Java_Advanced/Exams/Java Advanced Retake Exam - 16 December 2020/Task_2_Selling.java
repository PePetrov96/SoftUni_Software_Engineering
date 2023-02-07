import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Selling {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static char[][] bakery;
    static byte size;
    static byte row;
    static byte col;
    static byte pillarOneRow;
    static byte pillarOneCol;
    static byte pillarTwoRow;
    static byte pillarTwoCol;
    static int profit;
    static boolean out_Of_The_Bakery = false;

    public static void main(String[] args) throws IOException{
        initialize();

        while (profit < 50 && !out_Of_The_Bakery) {
            move(reader.readLine());
        }

        printResult();
    }

    private static void printResult(){
        if (!out_Of_The_Bakery) {
            bakery[row][col] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }

        System.out.println("Money: " + profit);

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(bakery[i]).replaceAll("[\\[\\], ]",""));
        }
    }
    private static void move(String direction){
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

        checkPosition();
    }
    private static void checkPosition(){
        if (row < 0 || col < 0 || row >= size || col >= size) {
            out_Of_The_Bakery = true;
            return;
        }

        char current = bakery[row][col];

        if (Character.isDigit(current)) {
            profit += Integer.parseInt(String.valueOf(current));
        } else if (current == 'O') {
            bakery[row][col] = '-';
            if (pillarOneRow == row && pillarOneCol == col) {
                row = pillarTwoRow;
                col = pillarTwoCol;
            } else {
                row = pillarOneRow;
                col = pillarOneCol;
            }
        }

        bakery[row][col] = '-';
    }
    private static void initialize() throws IOException{
        size = Byte.parseByte(reader.readLine());

        bakery = new char[size][size];

        for (byte i = 0; i < size; i++) {
            String line = reader.readLine()
                    .replaceAll("\\s+","");

            if (line.contains("S") || line.contains("O")) {
                getPositions(i, line);
            }

            bakery[i] = line
                    .replaceAll("S","-")
                    .toCharArray();
        }
    }
    private static void getPositions(byte i, String line){
        boolean foundFirst = false;
        for (byte j = 0; j < line.length(); j++) {
            char curr = line.charAt(j);

            if (curr == 'S') {
                row = i;
                col = j;
            } else if (curr == 'O') {
                if (!foundFirst) {
                    pillarOneRow = i;
                    pillarOneCol = j;
                    foundFirst = true;
                } else {
                    pillarTwoRow = i;
                    pillarTwoCol = j;
                }
            }
        }
    }
}