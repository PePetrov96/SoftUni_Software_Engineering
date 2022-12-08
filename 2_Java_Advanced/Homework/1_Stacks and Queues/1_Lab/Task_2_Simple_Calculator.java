import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Task_2_Simple_Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<String> result = new ArrayDeque<>();
        String[] tokens = scan.nextLine().split("\\s+");
        Collections.addAll(result, tokens);

        while (result.size() > 1) {
            int first = Integer.parseInt(result.pop());
            String operand = result.pop();
            int second = Integer.parseInt(result.pop());

            switch (operand) {
                case "+": result.push(String.valueOf(first + second)); break;
                case "-": result.push(String.valueOf(first - second)); break;
            }
        }
        System.out.println(result.peek());
    }
}