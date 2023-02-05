import java.util.*;
import java.util.stream.Collectors;

public class Task_7_Remove_Negatives_and_Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(n -> n < 0);
        Collections.reverse(numbers);

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}