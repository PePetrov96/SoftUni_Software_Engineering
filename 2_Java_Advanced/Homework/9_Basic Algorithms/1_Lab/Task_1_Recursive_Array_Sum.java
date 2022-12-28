import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_1_Recursive_Array_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(array, 0));
    }
    static int sum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }
        return array[index] + sum(array, index + 1);
    }
}