import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_1_Recursive_Array_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(sumArray(numbers));
    }
    public static int sumArray(int[] array) {
        return sum(array, 0);
    }

    private static int sum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        } else {
            return array[index] + sum(array, index + 1);
        }
    }
}