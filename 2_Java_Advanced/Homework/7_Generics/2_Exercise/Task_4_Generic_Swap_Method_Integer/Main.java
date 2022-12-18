import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GenericList<Integer> list = new GenericList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        int[] swap = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        list.swap(swap[0], swap[1]);

        list.printToString();
    }
}