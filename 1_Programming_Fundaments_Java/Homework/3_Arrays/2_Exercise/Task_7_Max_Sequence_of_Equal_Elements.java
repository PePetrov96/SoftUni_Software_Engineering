import java.util.Arrays;
import java.util.Scanner;

public class Task_7_Max_Sequence_of_Equal_Elements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int digit = 0, count = 1, max = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                count++;
                if (count > max) {
                    digit = numbers[i];
                    max = count;
                }
            }else {
                count = 1;
            }
        }
        for (int i = 0; i < max; i++) {
            System.out.print(digit + " ");
        }
    }
}