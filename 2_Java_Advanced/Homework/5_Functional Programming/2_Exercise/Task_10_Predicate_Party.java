import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task_10_Predicate_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> guestList = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String input;
        while (!"Party!".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            modifyList(tokens[0], guestList, createFilter(tokens[1], tokens[2]));
        }

        if (guestList.size() > 0) {
            guestList = guestList.stream().sorted().collect(Collectors.toList());
            System.out.println(guestList.toString().replaceAll("[\\[\\]]","") + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
    private static void modifyList(String command, List<String> guestList, Predicate<String> filter) {
        switch (command) {
            case "Remove":
                guestList.removeIf(filter);
                break;
            case "Double":
                for (int i = 0; i < guestList.size(); i++) {
                    if (filter.test(guestList.get(i))) {
                        guestList.add(i, guestList.get(i));
                        i++;
                    }
                }
                break;
        }
    }
    private static Predicate<String> createFilter (String command, String subString) {
        Predicate<String> filter = null;
        switch (command) {
            case "StartsWith":
                filter = string -> string.startsWith(subString); break;
            case "EndsWith":
                filter = string -> string.endsWith(subString); break;
            case "Length":
                filter = string -> string.length() == Integer.parseInt(subString); break;
        }
        return filter;
    }
}