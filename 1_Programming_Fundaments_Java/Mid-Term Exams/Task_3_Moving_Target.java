import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_3_Moving_Target {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scan.nextLine().split(" ");

        while (!command[0].equals("End")) {
            switch (command[0]) {
                case "Shoot":
                    shoot(Integer.parseInt(command[1]), Integer.parseInt(command[2]), targets);
                    break;
                case "Add":
                    add(Integer.parseInt(command[1]), Integer.parseInt(command[2]), targets);
                    break;
                case "Strike":
                    strike(Integer.parseInt(command[1]), Integer.parseInt(command[2]), targets);
                    break;
            }
            command = scan.nextLine().split(" ");
        }
        printOut(targets);
    }
    private static void shoot (int index, int power, List<Integer> targets) {
        if (index >= 0 && index < targets.size()) {
            if (targets.get(index) - power <= 0) {
                targets.remove(index);
            } else {
                targets.set(index, targets.get(index) - power);
            }
        }
    }
    private static void add (int index, int value, List<Integer> targets) {
        if (index >= 0 && index < targets.size()) {
            targets.add(index, value);
        } else {
            System.out.println("Invalid placement!");
        }
    }

    private static void strike (int index, int radius, List<Integer> targets) {
        boolean isStruck = false;
        if ((index - radius) >= 0 && (index + radius) < targets.size()) {
            isStruck = true;
        }
        if (isStruck) {
            int removeIndex = (index - radius);
            for (int i = removeIndex; i <= (index + radius); i++) {
                targets.remove(removeIndex);
            }
        } else {
            System.out.println("Strike missed!");
        }
    }
    private static void printOut (List<Integer> targets) {
        for (int i = 0; i < targets.size(); i++) {
            if (i == targets.size() - 1) {
                System.out.print(targets.get(i));
            } else {
                System.out.print(targets.get(i) + "|");
            }
        }
    }
}