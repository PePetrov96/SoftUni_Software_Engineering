import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task_4_Basic_Queue_Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] commands = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] array = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < commands[0]; i++) { //add
            if (array.length == i - 1) break;
            queue.add(array[i]);
        }

        for (int i = 0; i < commands[1]; i++) { //remove
            if (queue.isEmpty()) break;
            queue.remove();
        }

        if (queue.contains(commands[2])) {
            System.out.println(queue.contains(commands[2]));
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            int minNum = Integer.MAX_VALUE;
            for (int element : queue) {
                if (element < minNum) {
                    minNum = element;
                }
            }
            System.out.println(minNum);
        }
    }
}