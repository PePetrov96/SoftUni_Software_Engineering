import java.util.Arrays;
import java.util.Scanner;

public class Task_4_Array_Rotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int n = Integer.parseInt(scan.nextLine());

        for (int j = 0; j < n; j++) {
            int firstDigit = numbers[0];
            for (int i = 1; i <= numbers.length - 1; i++) {
                if (i == (numbers.length - 1)) {
                    numbers[i - 1] = numbers[i];
                    numbers[numbers.length - 1] = firstDigit;
                } else {
                    numbers[i - 1] = numbers[i];
                }
            }
        }
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[,|\\]]", ""));
    }
}