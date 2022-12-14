import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Task_3_Count_Uppercase_Words {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));
        List<String> result = new ArrayList<>();

        for (String s : input) {
            if (isUpperCase.test(s)) result.add(s);
        }

        System.out.println(result.size());
        result.forEach(System.out::println);
    }
}