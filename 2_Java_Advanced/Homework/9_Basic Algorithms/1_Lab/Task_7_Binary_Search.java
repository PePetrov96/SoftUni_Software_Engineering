import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_7_Binary_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int find = Integer.parseInt(reader.readLine());

        System.out.println(getIndex(array, find));

    }
    static int getIndex(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (key < array[middle]) {
                end = middle - 1;
            } else if (key > array[middle]){
                start = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
