import java.util.Scanner;

public class Task_4_Back_In_30_Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalMinutes = (scan.nextInt() * 60) + scan.nextInt() + 30;

        if ((totalMinutes / 60) == 24) {
            System.out.printf("%d:%02d", 0, (totalMinutes % 60));
        } else {
            System.out.printf("%d:%02d", (totalMinutes / 60), (totalMinutes % 60));
        }
    }
}
