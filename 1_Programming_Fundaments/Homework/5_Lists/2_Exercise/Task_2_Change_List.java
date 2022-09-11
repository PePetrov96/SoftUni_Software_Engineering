import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_2_Change_List {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer :: parseInt).collect(Collectors.toList());
        String[] input = scan.nextLine().split(" ");

        while (!input[0].equals("end")) {
            switch (input[0]) {
                case "Delete":
                    deleteItems(numbers, Integer.parseInt(input[1]));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(input[2]), Integer.valueOf(input[1]));
                    break;
            }
            input = scan.nextLine().split(" ");
        }
        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
    private static void deleteItems (List<Integer> numbers, int delete) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == delete) {
                numbers.remove(i);
                i--;
            }
        }
    }
}