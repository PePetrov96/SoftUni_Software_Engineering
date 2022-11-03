import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_2_Word_Synonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, ArrayList<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String key = scan.nextLine();
            String value = scan.nextLine();

            synonyms.putIfAbsent(key, new ArrayList<>());
            synonyms.get(key).add(value);
        }

        for (Map.Entry<String, ArrayList<String>> synonym : synonyms.entrySet()) {
            System.out.print(synonym.getKey() + " - ");
            System.out.print(synonym.getValue().toString().replaceAll("[\\[\\]]", ""));
            System.out.println();
        }
    }
}