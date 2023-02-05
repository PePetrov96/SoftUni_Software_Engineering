import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_1_Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scan.nextLine());
        String[] input = scan.nextLine().split(" ");

        while (!input[0].equals("end")) {
            if (input[0].equals("Add")) {
                wagons.add(Integer.parseInt(input[1]));
            } else {
                checkAndAdd(wagons, Integer.parseInt(input[0]), maxCapacity);
            }
            input = scan.nextLine().split(" ");
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
    private static void checkAndAdd (List<Integer> wagons, int input, int maxCapacity) {
        for (int i = 0; i < wagons.size(); i++) {
            if ((input + wagons.get(i)) <= maxCapacity) {
                wagons.set(i, (input + wagons.get(i)));
                break;
            }
        }
    }
}