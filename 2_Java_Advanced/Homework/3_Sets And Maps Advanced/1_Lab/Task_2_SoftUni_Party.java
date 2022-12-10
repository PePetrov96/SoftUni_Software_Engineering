import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Task_2_SoftUni_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input;
        while (!"PARTY".equals(input = reader.readLine())) {
            if (Character.isDigit(input.charAt(0))) {
                VIP.add(input);
            } else {
                regular.add(input);
            }
        }

        while (!"END".equals(input = reader.readLine())) {
            if (Character.isDigit(input.charAt(0))) {
                VIP.remove(input);
            } else {
                regular.remove(input);
            }
        }

        System.out.println(VIP.size() + regular.size());
        VIP.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}