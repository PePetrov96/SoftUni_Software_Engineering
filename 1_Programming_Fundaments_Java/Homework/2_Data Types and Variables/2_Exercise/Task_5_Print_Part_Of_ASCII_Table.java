import java.util.Scanner;

public class Task_5_Print_Part_Of_ASCII_Table {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());
        String result = "";
        for (int i = num1; i <= num2; i++) {
            char character = (char) i;
            result += character + " ";
        }
        System.out.println(result);
    }
}
