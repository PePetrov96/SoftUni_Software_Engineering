import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_3_Generating_0_1_Vectors {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] vector = new int[n];

        generateVector(0, vector);

    }
    private static void generateVector(int index, int[] vector) {
        if (index >= vector.length) {
            print(vector);
        } else {
            for (int i = 0; i <= 1; i++) {
                vector[index] = i;
                generateVector(index + 1, vector);
            }
        }
    }
    private static void print(int[] vector) {
        System.out.println(Arrays.toString(vector).replaceAll("[\\[\\], ]",""));
    }
}