import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Task_1_Unique_Usernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        LinkedHashSet<String> words = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) words.add(reader.readLine());

        words.forEach(System.out::println);
    }
}