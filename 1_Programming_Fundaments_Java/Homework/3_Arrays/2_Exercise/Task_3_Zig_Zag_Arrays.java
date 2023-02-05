import java.util.Arrays;
import java.util.Scanner;

public class Task_3_Zig_Zag_Arrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] firstText = new int[n];
        int[] secondText = new int[n];

        for (int i = 1; i <= n; i++) {
            int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i % 2 != 0) {
                firstText[i - 1] = numbers[0];
                secondText[i - 1] = numbers[1];
            } else {
                firstText[i - 1] = numbers[1];
                secondText[i - 1] = numbers[0];
            }
        }
        System.out.println(Arrays.toString(firstText).replaceAll("[\\[,|\\]]", "") + "\n" + Arrays.toString(secondText).replaceAll("[\\[,|\\]]", ""));
    }
}