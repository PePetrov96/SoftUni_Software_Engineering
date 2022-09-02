import java.util.Arrays;
import java.util.Scanner;

public class Task_5_Top_Integers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
        int[] topThree = new int[3];

        for (int i = 0; i < numbers.length; i++) {
            boolean isTop = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] <= numbers[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}