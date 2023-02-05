import java.util.Scanner;

public class Task_1_Day_of_Week {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int input = Integer.parseInt(scan.nextLine());
        if (input > 0 && input < 8) {
            System.out.println(days[input - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}