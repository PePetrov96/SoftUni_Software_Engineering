import java.util.Arrays;
import java.util.Scanner;

public class Task_2_Shoot_for_the_Win {
    public static void main(String[] args)   {
        Scanner scan = new Scanner(System.in);
        int[] targets = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scan.nextLine();

        while (!command.equals("End")) {
            int shotIndex = Integer.parseInt(command);
            if (shotIndex < 0 || shotIndex > targets.length - 1) {
                command = scan.nextLine();
                continue;
            } else if (targets[shotIndex] == -1) {
                command = scan.nextLine();
                continue;
            } else {
                shoot(targets, shotIndex);
            }

            command = scan.nextLine();
        }
        printOut(targets);
    }
    private static void shoot (int[] targets, int shotIndex) {
        for (int i = 0; i < targets.length; i++) {
            if (i == shotIndex || targets[i] == -1) {
                continue;
            }
            if (targets[i] > targets[shotIndex]) {
                targets[i] = targets[i] - targets[shotIndex];
            } else if (targets[i] <= targets[shotIndex]) {
                targets[i] = targets[i] + targets[shotIndex];
            }
        }
        targets[shotIndex] = -1;
    }
    private static void printOut (int[] targets) {
        int count = 0;
        for (int j : targets) {
            if (j == -1) {
                count++;
            }
        }
        System.out.printf("Shot targets: %d ->", count);
        for (int target : targets) {
            System.out.print(" " + target);
        }
    }
}