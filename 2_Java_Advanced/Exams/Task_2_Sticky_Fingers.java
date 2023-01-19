import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_2_Sticky_Fingers {
    static char[][] field;
    static int size;
    static byte row;
    static byte col;
    static String[] commands;
    static int stolen = 0;
    static boolean inJail = false;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        size = Integer.parseInt(reader.readLine());
        
        commands = reader.readLine().split(",");
        
        returnMatrix();
        
        beginSequence();

        print();
    }

    private static void print() {
        if (!inJail) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolen);
            field[row][col] = 'D';
        }

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(field[i]).replaceAll("[\\[\\],]",""));
        }
    }
    
    private static void beginSequence() {
        for (int i = 0; i < commands.length && !inJail; i++) {
            move(commands[i]);
            assesPosition();
        }
    }
    private static void assesPosition() {
        switch (field[row][col]) {
            case '$':
                field[row][col] = '+';
                int stole = (row * col);
                System.out.printf("You successfully stole %d$.%n", stole);
                stolen += stole;
                break;
            case 'P':
                field[row][col] = '#';
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolen);
                inJail = true;
                break;
            default:
                return;
        }
    }

    private static void move(String direction) {
        switch (direction) {
            case "up":
                if ((row-1) >= 0) {
                    row--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
                break;
            case "down":
                if ((row+1) < size) {
                    row++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
                break;
            case "left":
                if ((col-1) >= 0) {
                    col--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
                break;
            case "right":
                if ((col+1) < size) {
                    col++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
                break;
        }
    }
    private static void returnMatrix() throws IOException {
        field = new char[size][size];

        for (byte i = 0; i < size; i++) {
            String line = reader.readLine();

            if (line.contains("D")) {
                row = i;
                col = getCol(line.replaceAll(" ", ""));
            }

            field[i] = line.replace(" ", "").replace("D","+").toCharArray();
        }
    }
    private static byte getCol(String line) {
        for (byte i = 0; i < size; i++) {
            if (line.charAt(i) == 'D') {
                return i;
            }
        }
        return 0;
    }
}