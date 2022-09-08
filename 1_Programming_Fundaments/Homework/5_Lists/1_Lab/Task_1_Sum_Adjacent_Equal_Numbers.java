import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_1_Sum_Adjacent_Equal_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = new java.util.ArrayList<>(Arrays.stream(scan.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList()));
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))){
                numbers.set(i, (numbers.get(i) + numbers.get(i + 1)));
                numbers.remove(i + 1);
                i = -1;
            }
        }
        String output = joinElementsByDelimiter(numbers);
        System.out.println(output);
    }
    static String joinElementsByDelimiter (List<Double> items) {
        String output = "";
        for (Double item : items) {
            output += (new DecimalFormat("0.#").format(item) + " ");
        }
        return output;
    }
}