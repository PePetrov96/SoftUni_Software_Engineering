import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_6_Predicate_For_Names {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

//        Predicate<String> filter = name -> name.length() <= n;
//        for (String name : names) {
//            if (filter.test(name)) System.out.println(name);
//        }
        names.stream()
                .filter(name -> name.length() <= n)
                .forEach(System.out::println);
    }
}