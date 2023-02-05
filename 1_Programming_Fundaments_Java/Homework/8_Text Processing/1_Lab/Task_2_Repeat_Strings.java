import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_Repeat_Strings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        List<String> result = new ArrayList<>();

        for (String word : words) {
            result.add(word.repeat(word.length()));
        }
        System.out.println(String.join("", result));
    }
}