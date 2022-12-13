import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class Task_6_Fix_Emails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, String> contacts = new LinkedHashMap<>();

        Pattern p = Pattern.compile("\\.com$|\\.uk$|\\.us$");

        String input;
        while (!"stop".equals(input = reader.readLine())) {
            String email = reader.readLine();
            if (!p.matcher(email).find()) {
                contacts.put(input, email);
            }

        }

        contacts
                .forEach((key, value) ->
                        System.out.println(key + " -> " + value));
    }
}