import java.util.Arrays;
import java.util.Scanner;

public class Task_1_Reverse_Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        reverseAndPrintArray(array);
    }
    public static void reverseAndPrintArray(int[] arr) {
        reverseAndPrintArrayRecursive(arr, 0);
    }

    private static void reverseAndPrintArrayRecursive(int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }

        reverseAndPrintArrayRecursive(arr, index + 1);

        System.out.print(arr[index] + " ");
    }
}
