import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task_11_The_Party_Reservation_Filter_Module {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> guestList = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> filterList = new ArrayList<>();

        String input;
        while (!"Print".equals(input = reader.readLine())) {
            modifyFilters(filterList, input.split(";"));
        }

        for (String s : filterList) {
            String[] tokens = s.split("\\s");
            Predicate<String> filter = createFilter(tokens[0], tokens[1]);
            guestList.removeIf(filter);
        }

        System.out.println(guestList.toString().replaceAll("[\\[\\],]",""));
    }
    private static void modifyFilters (List<String> filterList, String[] input) {
        String filter;

        if (input[1].equals("Starts with") || input[1].equals("Ends with")) {
            String temp = input[1].replaceAll("\\s+", "");
            filter = temp.concat(" ").concat(input[2]);
        } else {
            filter = input[1].concat(" ").concat(input[2]);
        }

        if (input[0].equals("Add filter")) {
            filterList.add(filter);
        } else {
            filterList.remove(filter);
        }

    }
    private static Predicate<String> createFilter (String command, String subString) {
        Predicate<String> filter = null;
        switch (command) {
            case "Startswith":
                filter = string -> string.startsWith(subString); break;
            case "Endswith":
                filter = string -> string.endsWith(subString); break;
            case "Length":
                filter = string -> string.length() == Integer.parseInt(subString); break;
            case "Contains":
                filter = string -> string.contains(subString); break;
        }
        return filter;
    }
}