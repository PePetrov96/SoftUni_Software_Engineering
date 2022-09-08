import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_5_List_Manipulation_Advanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer :: parseInt).collect(Collectors.toList());
        String[] command = scan.nextLine().split(" ");

        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Contains":
                    if (numbers.contains(Integer.parseInt(command[1]))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    printEvenOrOdd(numbers, command[1]);
                    break;
                case "Get":
                    printSum(numbers);
                    break;
                case "Filter":
                    printFiltered(numbers, command[1], Integer.parseInt(command[2]));
                    break;
            }
            command = scan.nextLine().split("\\s+");
        }
    }
    private static void printEvenOrOdd (List<Integer> numbers, String evenOrOdd) {
        List<Integer> toPrint = new ArrayList<>();
        for (Integer number : numbers) {
            if (evenOrOdd.equals("even")) {
                if (number % 2 == 0) {
                    toPrint.add(number);
                }
            } else if (evenOrOdd.equals("odd")) {
                if (number % 2 != 0) {
                    toPrint.add(number);
                }
            }
        }
        System.out.println(toPrint.toString().replaceAll("[\\[\\],]", ""));
    }
    private static void printSum (List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
    private static void printFiltered (List<Integer> numbers, String filter, int numberFilter) {
        List<Integer> temp = new ArrayList<>();
        for (Integer number : numbers) {
            switch (filter) {
                case "<":
                    if (number < numberFilter) {
                        temp.add(number);
                    }
                    break;
                case ">":
                    if (number > numberFilter) {
                        temp.add(number);
                    }
                    break;
                case ">=":
                    if (number >= numberFilter) {
                        temp.add(number);
                    }
                    break;
                case "<=":
                    if (number <= numberFilter) {
                        temp.add(number);
                    }
                    break;
            }
        }
        System.out.println(temp.toString().replaceAll("[\\[\\],]", ""));
    }
}
