import java.util.Scanner;

public class Task_5_Month_Printer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (number > 12 || number < 1) {
            System.out.println("Error!");
        } else {
            System.out.println(month[number - 1]);
        }
    }
}