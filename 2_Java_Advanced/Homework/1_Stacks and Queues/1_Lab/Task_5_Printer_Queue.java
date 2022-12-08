import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_5_Printer_Queue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> result = new ArrayDeque<>();

        String input;
        while (!"print".equals(input = scan.nextLine())) {
            if (input.equals("cancel")) {
                if (result.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled "+ result.remove());
                }
            } else {
                result.add(input);
            }
        }
        while (!result.isEmpty()) {
            System.out.println(result.remove());
        }
    }
}