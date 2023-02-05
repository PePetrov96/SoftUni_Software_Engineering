import java.util.Arrays;
import java.util.Scanner;

public class Task_7_Condense_Array_to_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer :: parseInt).toArray();
        if (numbers.length == 1) {
            System.out.println(numbers[0]);
            return;
        }
        int[] condensed = new int[numbers.length - 1];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < condensed.length - i; j++) {
                condensed[j] = numbers[j] + numbers[j + 1];
            }
            numbers = condensed;
        }
        System.out.println(condensed[0]);
    }
}