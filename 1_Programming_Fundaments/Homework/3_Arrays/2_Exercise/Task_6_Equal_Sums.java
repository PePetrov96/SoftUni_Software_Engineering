import java.util.Arrays;
import java.util.Scanner;

public class Task_6_Equal_Sums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer :: parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (j < i) {
                    leftSum += numbers[j];
                } else if (j > i) {
                    rightSum += numbers[j];
                }
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}