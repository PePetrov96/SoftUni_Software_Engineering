import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_1_Messaging {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        resultNumbers(numbers);
        List<String> text = Arrays.stream(scan.nextLine().split("")).collect(Collectors.toList());

        System.out.println(resultText(numbers, text));
    }
    private static void resultNumbers (List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            String[] numberSum = String.valueOf(numbers.get(i)).split("");
            int sum = 0;
            for (String s : numberSum) {
                sum = sum + Integer.parseInt(s);
            }
            numbers.set(i, sum);
        }
    }
    private static String resultText (List<Integer> numbers, List<String> text) {
        String result = "";
        for (int i = 0; i < numbers.size(); i++) {
            while (numbers.get(i) > (text.size() - 1)) {
                numbers.set(i, (numbers.get(i) - text.size()));
            }
            result = result + "" + text.get(numbers.get(i));
            int index = numbers.get(i);
            text.remove(index);
        }
        return result;
    }
}