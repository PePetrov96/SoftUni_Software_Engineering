import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> peopleName = new TreeSet<>(new NameComparator());
        TreeSet<Person> peopleAge = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            peopleName.add(new Person(input));
            peopleAge.add(new Person(input));
        }

        peopleName.forEach(System.out::println);
        peopleAge.forEach(System.out::println);
    }
}