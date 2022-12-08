import java.util.*;

public class Task_1_Reverse_Numbers_with_a_Stack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String[] numArray = scan.nextLine().split("\\s+");

        for (String s : numArray) {
            numbers.push(Integer.valueOf(s));
        }

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}