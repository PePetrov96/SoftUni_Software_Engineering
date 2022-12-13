import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Task_3_Periodic_Table {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> compounds = new TreeSet<>();
        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {
            compounds.addAll(Arrays.asList(reader.readLine().split("\\s+")));
        }

        compounds
                .stream()
                .sorted(Comparator.naturalOrder())
                .forEach(entry -> System.out.print(entry + " "));

    }
}