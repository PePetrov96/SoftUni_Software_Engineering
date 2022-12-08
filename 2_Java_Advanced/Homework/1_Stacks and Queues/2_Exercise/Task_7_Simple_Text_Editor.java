import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task_7_Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> stack = new ArrayDeque<>();

        String text = "";

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "1":
                    stack.push(text);
                    text += command[1];
                    break;
                case "2":
                    stack.push(text);
                    text = text.substring(0, text.length() - Integer.parseInt(command[1]));
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(command[1]) - 1));
                    break;
                case "4":
                    text = stack.pop();
                    break;
            }
        }
    }
}