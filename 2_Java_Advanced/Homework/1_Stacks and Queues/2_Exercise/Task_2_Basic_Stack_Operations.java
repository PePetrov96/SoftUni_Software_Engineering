import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task_2_Basic_Stack_Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] commands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] array = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commands[0]; i++) { //push
            if (array.length == i - 1) break;
            stack.push(array[i]);
        }

        for (int i = 0; i < commands[1]; i++) { //pop
            if (stack.isEmpty()) break;
            stack.pop();
        }

        if (stack.contains(commands[2])) {
            System.out.println(stack.contains(commands[2]));
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            int minNum = Integer.MAX_VALUE;
            for (int element : stack) {
                if (element < minNum) {
                    minNum = element;
                }
            }
            System.out.println(minNum);
        }
    }
}