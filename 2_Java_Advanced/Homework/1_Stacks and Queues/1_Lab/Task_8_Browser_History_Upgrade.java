import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_8_Browser_History_Upgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String input;

        while (!"Home".equals(input = scanner.nextLine())) {

            if (input.equals("back")) {
                if (browserHistory.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forwardHistory.push(browserHistory.pop());
                    System.out.println(browserHistory.peek());
                }
            } else if (input.equals("forward")) {
                if (forwardHistory.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardHistory.peek());
                    browserHistory.push(forwardHistory.pop());
                }
            } else {
                System.out.println(input);
                browserHistory.push(input);
                forwardHistory.clear();
            }
        }
    }
}