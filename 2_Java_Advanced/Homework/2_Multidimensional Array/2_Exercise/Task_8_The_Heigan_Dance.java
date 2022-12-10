import java.util.Scanner;

public class Task_8_The_Heigan_Dance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double HeiganHP = 3000000.0;
        int PlayerHP = 18500;

        int startingRow = 7;
        int startingCol = 7;

        String lastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (PlayerHP > 0 && HeiganHP > 0) {
            HeiganHP -= damage;

            if (activeCloud) {
                PlayerHP -= 3500;
                activeCloud = false;
            }

            if (HeiganHP < 0 || PlayerHP < 0) {break;}

            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            boolean[][] chamber = new boolean[15][15];

            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < chamber.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < chamber[row].length) {
                            chamber[i][j] = true;
                        }
                    }
                }
            }

            if (chamber[startingRow][startingCol]) {
                if (isValidVertical(chamber, startingRow - 1) && !chamber[startingRow - 1][startingCol]) {
                    startingRow--; // move up
                } else if (isValidHorizontal(chamber, startingCol + 1) && !chamber[startingRow][startingCol + 1]) {
                    startingCol++; // move right
                } else if (isValidVertical(chamber, startingRow + 1) && !chamber[startingRow + 1][startingCol]) {
                    startingRow++; // move down
                } else if (isValidHorizontal(chamber, startingCol - 1) && !chamber[startingRow][startingCol - 1]) {
                    startingCol--; // move left
                }

                if (chamber[startingRow][startingCol]) {
                    switch (spell) {
                        case "Cloud":
                            PlayerHP -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            PlayerHP -= 6000;
                            lastSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        printResult(HeiganHP, PlayerHP, lastSpell, startingRow, startingCol);
    }
    private static void printResult (double HeiganHP, int PlayerHP, String lastSpell, int row, int col) {
        if (HeiganHP > 0) {
            System.out.printf("Heigan: %.2f%n", HeiganHP);
        } else {
            System.out.println("Heigan: Defeated!");
        }

        if (PlayerHP > 0) {
            System.out.printf("Player: %d%n", PlayerHP);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + row + ", " + col);
    }
    private static boolean isValidVertical(boolean[][] hsChamber, int startPlRow) {
        return startPlRow >= 0 && startPlRow < hsChamber[startPlRow].length;
    }
    private static boolean isValidHorizontal(boolean[][] hsChamber, int startPlCol) {
        return startPlCol >= 0 && startPlCol < hsChamber.length;
    }
}