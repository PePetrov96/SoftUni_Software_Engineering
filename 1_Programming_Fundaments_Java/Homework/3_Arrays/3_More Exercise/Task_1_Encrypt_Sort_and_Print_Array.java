import java.util.Arrays;
import java.util.Scanner;

public class Task_1_Encrypt_Sort_and_Print_Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            int nameSum = 0;
            for (int j = 0; j < name.length(); j++) {
                char current = name.charAt(j);
                if (name.charAt(j) == 'a' || name.charAt(j) == 'e' || name.charAt(j) == 'i' || name.charAt(j) == 'o' ||  name.charAt(j) == 'u' ||
                        name.charAt(j) == 'A' || name.charAt(j) == 'E' || name.charAt(j) == 'I' || name.charAt(j) == 'O' ||  name.charAt(j) == 'U') {
                    nameSum += current * name.length();
                } else {
                    nameSum += current / name.length();
                }
            }
            numbers[i] = nameSum;
        }
        Arrays.sort(numbers);
        for (int print : numbers) {
            System.out.println(print);
        }
    }
}