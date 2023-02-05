import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_4_List_Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scan.nextLine().split(" ");

        while (!input[0].equals("End")) {
            switch (input[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(input[1]));
                    break;
                case "Insert":
                    insert(numbers, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    break;
                case "Remove":
                    remove(numbers, Integer.parseInt(input[1]));
                    break;
                case "Shift":
                    shift(numbers, input[1], Integer.parseInt(input[2]));
                    break;
            }
            input = scan.nextLine().split(" ");
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void remove (List<Integer> numbers, int index) {
        if (0 > index || index >= numbers.size()) {
            System.out.println("Invalid index");
        } else {
            numbers.remove(index);
        }
    }
    private static void insert (List<Integer> numbers, int number, int index) {
        if (0 > index || index >= numbers.size()) {
            System.out.println("Invalid index");
        } else {
            numbers.add(index, number);
        }
    }
    private static void shift (List<Integer> numbers, String command, int count) {
        if (command.equals("left")) {
            for (int i = 0; i < count; i++) {
                int number = numbers.get(0);
                numbers.remove(0);
                numbers.add(number);
            }
        } else if (command.equals("right")) {
            for (int i = 0; i < count; i++) {
                int number = numbers.get(numbers.size() - 1);
                numbers.remove((numbers.size() - 1));
                numbers.add(0, number);
            }
        }
    }
}