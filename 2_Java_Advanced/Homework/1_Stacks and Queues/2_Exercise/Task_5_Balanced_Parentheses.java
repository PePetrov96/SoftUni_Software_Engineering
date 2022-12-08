import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task_5_Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] parentheses = scanner.nextLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        boolean result = true;

        for (char current : parentheses) {
            switch (current) {
                case '(': stack.push(')'); break;
                case '[': stack.push(']'); break;
                case '{': stack.push('}'); break;
                case ')':
                case ']':
                case '}': if (stack.isEmpty() || stack.pop() != current) result = false; break;
                default: break;
            }

            if (!result) break;
        }

        System.out.println(result ? "YES" : "NO");
    }
}