import java.util.Scanner;

public class Task_2_English_Name_of_the_Last_Digit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String[] textNumber = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int last = num % 10;
        System.out.println(textNumber[last]);
    }
}