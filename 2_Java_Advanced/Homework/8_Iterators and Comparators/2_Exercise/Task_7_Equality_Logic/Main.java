import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> people1 = new TreeSet<>();
        HashSet<Person> people2 = new HashSet<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            people1.add(new Person(input));
            people2.add(new Person(input));
        }

        System.out.println(people1.size());
        System.out.println(people2.size());
    }
}