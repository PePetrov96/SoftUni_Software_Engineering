import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_5_Merge_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        mergeSort(array);

        System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
    }
    static int[] mergeSort(int[] array) {

        if (array.length == 1) {
            return array;
        }

        int firstArrayLength = array.length / 2;
        int secondArrayLength = array.length - firstArrayLength;

        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];

        System.arraycopy(array, 0, firstPartition, 0, firstArrayLength);
        System.arraycopy(array, firstArrayLength, secondPartition, 0, secondArrayLength);

        mergeSort(firstPartition);
        mergeSort(secondPartition);

        int mainIndex = 0;

        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < firstArrayLength && secondPartitionIndex < secondArrayLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex] = firstPartition[firstPartitionIndex];

                mainIndex++;
                firstPartitionIndex++;
            } else {
                array[mainIndex] = secondPartition[secondPartitionIndex];

                mainIndex++;
                secondPartitionIndex++;
            }
        }

        while (firstPartitionIndex < firstArrayLength) {
            array[mainIndex] = firstPartition[firstPartitionIndex];

            mainIndex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex < secondArrayLength) {
            array[mainIndex] = secondPartition[secondPartitionIndex];

            mainIndex++;
            secondPartitionIndex++;
        }

        return array;
    }
}