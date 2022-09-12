import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_2_Mu_Online {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> dungeon = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        int health = 100;
        int Coins = 0;
        boolean isDead = false;

        for (int i = 0; i < dungeon.size(); i++) {
            String[] currentRoom = dungeon.get(i).split(" ");
            switch (currentRoom[0]) {
                case "potion":
                    int Potion = Integer.parseInt(currentRoom[1]);
                    if (Potion + health > 100) {
                        Potion = 100 - health;
                        health = 100;
                    } else {
                        health += Potion;
                    }
                    System.out.printf("You healed for %d hp.%n", Potion);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    System.out.println("You found " + Integer.parseInt(currentRoom[1]) + " bitcoins.");
                    Coins += Integer.parseInt(currentRoom[1]);
                    break;
                default:
                    if (health - Integer.parseInt(currentRoom[1]) <= 0) {
                        System.out.printf("You died! Killed by %s.%n", currentRoom[0]);
                        System.out.printf("Best room: %d%n", i + 1);
                        isDead = true;
                        break;
                    } else {
                        System.out.printf("You slayed %s.%n", currentRoom[0]);
                    }
                    health -= Integer.parseInt(currentRoom[1]);
                    break;
            }
            if (isDead) {
                break;
            }
            if (i == (dungeon.size() - 1)) {
                System.out.printf("You've made it!%n" + "Bitcoins: %d%n" + "Health: %d", Coins, health);
            }
            currentRoom = dungeon.get(i).split(" ");
        }
    }
}