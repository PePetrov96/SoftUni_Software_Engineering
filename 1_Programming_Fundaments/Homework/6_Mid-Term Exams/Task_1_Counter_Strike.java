import java.util.Scanner;

public class Task_1_Counter_Strike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int energy = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int wonBattles = 0;
        boolean isWon = false;

        while (true) {
            if (input.equals("End of battle")) {
                isWon = true;
                break;
            }
            int nextBattle = Integer.parseInt(input);

            if ((energy - nextBattle) < 0) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, energy);
                break;
            } else if ((energy - nextBattle) >= 0) {
                wonBattles++;
                energy = energy - nextBattle;
            }

            if (wonBattles % 3 == 0) {
             energy = energy + wonBattles;
            }

            input = scan.nextLine();
        }
        if (isWon) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, energy);
        }
    }
}