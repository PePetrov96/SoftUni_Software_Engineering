import java.util.Arrays;
import java.util.Scanner;

public class Task_6_Equal_Arrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int diffIndex = 0;
        boolean isIdentical = true;

        int[] numbers1 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] numbers2 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int j = 0; j < numbers1.length; j++) {
            if (numbers1[j] == numbers2[j]) {
                sum += numbers1[j];
            } else {
                System.out.println("Arrays are not identical. Found difference at " + j + " index.");
                isIdentical = false;
                break;
            }
        }
        if (isIdentical) {
            System.out.println("Arrays are identical. Sum: " + sum);
        }
    }
}