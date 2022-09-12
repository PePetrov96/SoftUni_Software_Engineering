import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_3_Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> journal = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        String[] input = scan.nextLine().split(" - ");

        while (!input[0].equals("Craft!")) {

            switch (input[0]) {
                case "Collect":
                    if (!journal.contains(input[1])) {
                        journal.add(input[1]);
                    }
                    break;
                case "Drop":
                    journal.remove(input[1]);
                    break;
                case "Combine Items":
                    combine(journal, input[1]);
                    break;
                case "Renew":
                    renew(journal, input[1]);
                    break;
            }
            input = scan.nextLine().split(" - ");
        }
        printOut(journal);
    }
    private static void combine (List<String> journal, String input) {
        String[] items = input.split(":");
        if (journal.contains(items[0])) {
            int atIndex = 0;
            for (int i = 0; i < journal.size(); i++) {
                if (journal.get(i).equals(items[0])) {
                    atIndex = i;
                }
            }
            journal.add(atIndex + 1, items[1]);
        }
    }
    private static void renew (List<String> journal, String input) {
        if (journal.contains(input)) {
            journal.remove(input);
            journal.add(input);
        }
    }
    private static void printOut (List<String> journal) {
        for (int i = 0; i < journal.size(); i++) {
            if (i == journal.size()-1) {
                System.out.print(journal.get(i));
            } else {
                System.out.print(journal.get(i) + ", ");
            }
        }
    }
}