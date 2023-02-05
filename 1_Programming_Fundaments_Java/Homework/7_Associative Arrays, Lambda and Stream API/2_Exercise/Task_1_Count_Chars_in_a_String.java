import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task_1_Count_Chars_in_a_String {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().replaceAll(" ", "").split("");
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String s : input) {
            if (!counts.containsKey(String.valueOf(s))) {
                counts.put(String.valueOf(s), 0);
            }
            counts.put(String.valueOf(s), counts.get(String.valueOf(s)) + 1);
        }

        counts.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}