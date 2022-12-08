import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Task_3_Maximum_Element {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            switch (input[0]) {
                case 1: stack.push(input[1]); break;
                case 2: stack.remove(); break;
                case 3:
                    int max = Integer.MIN_VALUE;
                    for (int element : stack) if (element > max) max = element;
                    System.out.println(max);
                    break;
            }
        }
    }
}