import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_1_Number_in_Range {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        int[] range = Arrays.stream(reader.readLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.printf("Range: [%d...%d]%n", range[0], range[1]);

        int num = readNumInRange(range[0], range[1]);

        System.out.println("Valid number: " + num);

    }
    private static int readNumInRange(int start, int end) throws IOException {
        while (true) {
            String line = reader.readLine();
            try {
                int num = Integer.parseInt(line);
                if (num >= start && num <= end)
                    return num;
            } catch (Exception ignored) {}

            System.out.println("Invalid number: " + line);
        }
    }
}