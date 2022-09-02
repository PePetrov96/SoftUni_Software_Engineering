import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task_10_Treasure_Hunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] loot = scan.nextLine().split("\\|");
        String input = scan.nextLine();

        while (!input.equals("Yohoho!")) {
            String []commandLine = input.split(" ");
            String commands = commandLine[0];
            switch (commands) {
                case "Loot":
                    String addResource = "";
                    for (int i = 1; i < commandLine.length; i++) {
                        boolean isUnique = true;
                        for (String s : loot) {
                            if (commandLine[i].equals(s)) {
                                isUnique = false;
                            }
                        }
                        if (isUnique) {
                            addResource += commandLine[i] + " ";
                        }
                    }
                    String[] add = addResource.split(" ");
                    loot = Stream.concat(Arrays.stream(add), Arrays.stream(loot)).toArray(String[] :: new);
                    break;
                case "Drop":
                    int Index = Integer.parseInt(commandLine[1]);
                    if (Index >= 0 && Index < loot.length) {
                        for (int i = Index; i < loot.length; i++) {
                            loot[i] = loot[i + 1];
                        }
                        loot[loot.length - 1] = loot[Index];
                    }
                    break;
                case "Steal":
                    String[] removeResource = new String[loot.length - 1];
                    String removing = "";
                    int remove = Integer.parseInt(commandLine[1]);
                    if (loot.length < remove) {
                        remove = loot.length;
                    }
                    for (int i = loot.length - 1; i > loot.length - remove; i--) {
                        removing = loot[i] + " " + removing;
                    }
                    System.out.println(String.format(removing).replaceAll("[\\[|\\]]", ""));
                    loot = removeResource;
                    break;
            }
            input = scan.nextLine();
        }
        double sum = 0;
        for (String s : loot) {
            double size = s.length();
            sum += size;
        }
        sum /= loot.length;
        if (loot.equals(null)) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("\nAverage treasure gain: %.2f pirate credits.", sum);
        }
    }
}