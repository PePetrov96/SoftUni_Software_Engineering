import java.util.*;

public class Task_1_Browser_History {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input;

        while (!"Home".equals(input = scan.nextLine())) {
            if (input.equals("back") && stack.size() <= 1) {
                System.out.println("no previous URLs");
            } else if (input.equals("back")) {
                stack.pop();
                System.out.println(stack.peek());
            } else {
                stack.push(input);
                System.out.println(stack.peek());
            }
        }
    }
}