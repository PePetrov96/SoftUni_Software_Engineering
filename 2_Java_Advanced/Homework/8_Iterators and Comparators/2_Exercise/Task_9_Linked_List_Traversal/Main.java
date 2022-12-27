import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {
            String[] input = reader.readLine().split("\\s+");

            switch (input[0]) {
                case "Add": list.add(Integer.parseInt(input[1])); break;
                case "Remove": list.remove(Integer.parseInt(input[1])); break;
            }

        }

        System.out.println(list.getSize());
        System.out.println(list);
    }
}
