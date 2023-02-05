import java.util.Scanner;

public class Task_2_Sum_Digits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int sum = 0;
        String numLength = Integer.toString(number);
        for (int i = 1; i <= numLength.length(); i++) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        System.out.println(sum);
    }
}