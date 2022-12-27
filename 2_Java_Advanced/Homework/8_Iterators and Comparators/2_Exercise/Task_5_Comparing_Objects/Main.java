import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            personList.add(new Person(input));
        }

        int index = Integer.parseInt(reader.readLine()) - 1;

        matchAndPrint(personList, index);
    }
    public static void matchAndPrint (List<Person> personList, int index) {
        Person search = personList.get(index);

        int[] match = {0,0, personList.size()};

        for (Person person : personList) {
            if (person.compareTo(search) == 0) {
                match[0]++;
            } else {
                match[1]++;
            }
        }

        if (match[0] == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(Arrays.toString(match).replaceAll("[\\[\\],]", ""));
        }
    }
}