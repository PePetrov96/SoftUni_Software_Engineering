import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GenericList<String> list = new GenericList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {
            list.add(reader.readLine());
        }

        System.out.println(list.sumOfGreater(reader.readLine()));
    }
}