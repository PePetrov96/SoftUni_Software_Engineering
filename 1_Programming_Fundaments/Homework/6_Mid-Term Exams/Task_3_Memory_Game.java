import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_3_Memory_Game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        String[] input = scan.nextLine().split(" ");
        int moves = 0;

        while (!input[0].equals("end")) {
            if (numbers.size() == 0) {
                break;
            }
            moves++;

            runInput(Integer.parseInt(input[0]), Integer.parseInt(input[1]), numbers, moves);

            input = scan.nextLine().split(" ");
        }
        output(numbers, moves);
    }
    private static void output (List<String> numbers, int moves) {
        if (numbers.size() != 0) {
            System.out.println("Sorry you lose :(");
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println("You have won in " + moves + " turns!");
        }
    }
    private static void runMatch (int index1, int index2, List<String> numbers) {
        if (index1 > index2) {
            numbers.remove(index1);
            numbers.remove(index2);
        } else {
            numbers.remove(index2);
            numbers.remove(index1);
        }
    }
    private static void runCheat (List<String> numbers, int moves) {
        int middle = numbers.size() / 2;
        String number = "-" + moves + "a";
        numbers.add(middle, number);
        numbers.add(middle, number);
    }
    private static void runInput (int index1, int index2, List<String> numbers, int moves) {
        if (index1 < 0 || index2 < 0 || index1 > numbers.size() - 1 || index2 > numbers.size() - 1 || index1 == index2) {
            runCheat(numbers, moves);
            System.out.println("Invalid input! Adding additional elements to the board");
        } else if (numbers.get(index1).equals(numbers.get(index2))) {
            String print = numbers.get(index1);
            runMatch(index1, index2, numbers);
            System.out.println("Congrats! You have found matching elements - " + print + "!");
        } else {
            System.out.println("Try again!");
        }
    }
}