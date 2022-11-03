import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_1_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] nums = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (double num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }
            counts.put(num, counts.get(num) + 1);
        }
        DecimalFormat f = new DecimalFormat("#.#######");

        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%s -> %d%n", f.format(entry.getKey()), entry.getValue());
        }
    }
}