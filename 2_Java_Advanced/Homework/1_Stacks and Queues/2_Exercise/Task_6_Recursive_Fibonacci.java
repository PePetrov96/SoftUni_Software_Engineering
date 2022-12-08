import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_6_Recursive_Fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<Long> fibonacci = new ArrayDeque<>(); fibonacci.add(1L); fibonacci.add(1L);

        if (n > 1) for (int i = 1; i <= n; i++) fibonacci.offer(fibonacci.remove() + fibonacci.peek());

        System.out.println(fibonacci.pop());
    }
}