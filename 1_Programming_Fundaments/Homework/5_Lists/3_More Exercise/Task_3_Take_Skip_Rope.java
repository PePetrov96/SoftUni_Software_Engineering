import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3_Take_Skip_Rope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        format(input);
    }
    private static void format (String input) {
        List<Character> numbers = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                numbers.add(input.charAt(i));
            } else {
                characters.add(input.charAt(i));
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int numToAdd = Character.getNumericValue(numbers.get(i));
            if (i % 2 == 0) {
                takeList.add(numToAdd);
            } else {
                skipList.add(numToAdd);
            }
        }
        String string = characters.toString()
                .substring(1, 3 * characters.size() - 1)
                .replaceAll(", ", "");

        decodeString(string, takeList, skipList);
    }
    private static void decodeString (String string, List<Integer> takeList, List<Integer> skipList) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < takeList.size(); i++) {
            for (int j = 0; j < takeList.get(i); j++) {
                if (string.length() == 0) {
                    break;
                }
                newString.append(string.charAt(0));
                string = string.substring(1);
            }

            for (int j = 0; j < skipList.get(i); j++) {


                if (string.length() == 0) {
                    break;
                }
                string = string.substring(1);
            }
        }
        System.out.println(newString);
    }
}