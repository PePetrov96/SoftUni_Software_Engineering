import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split("\\s+");
        Tuple<String, String> first = new Tuple<>(strings[0]+" "+strings[1], strings[2]);

        String[] stringAndInteger = reader.readLine().split("\\s+");
        Tuple<String, Integer> second = new Tuple<>(stringAndInteger[0], Integer.parseInt(stringAndInteger[1]));

        String[] integerAndDouble = reader.readLine().split("\\s+");
        Tuple<Integer, Double> third = new Tuple<>(Integer.parseInt(integerAndDouble[0]), Double.parseDouble(integerAndDouble[1]));

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}