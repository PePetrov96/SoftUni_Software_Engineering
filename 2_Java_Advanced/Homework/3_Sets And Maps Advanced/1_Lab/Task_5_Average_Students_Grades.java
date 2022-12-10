import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Task_5_Average_Students_Grades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        TreeMap<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            if (!students.containsKey(input[0])) {
                students.put(input[0], new ArrayList<>());
            }
            students.get(input[0]).add(Double.parseDouble(input[1]));
        }

        students.forEach((key1, value) -> {
//            double sum = value.stream().mapToDouble(i -> i).sum(); //not registering correctly in judge
            double sum = 0;
            for (Double aDouble : value) { sum += aDouble; }
            double average = sum / value.size();
            System.out.print(key1 + " -> ");
            value.forEach(i -> System.out.printf("%.2f ", i));
            System.out.printf("(avg: %.2f)%n", average);
        });
    }
}