import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Task_5_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> phonebook = new HashMap<>();

        String input;
        while (!"search".equals(input = reader.readLine())) {
            String[] tokens = input.split("-");
            phonebook.put(tokens[0], tokens[1]);
        }

        while (!"stop".equals(input = reader.readLine())) {
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}