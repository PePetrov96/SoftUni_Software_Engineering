import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task_8_Academy_Graduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, List<Double>> students = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        for (int iterations = 0; iterations < n; iterations++) {
            String name = reader.readLine();
            double[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }

            for (double v : input) { students.get(name).add(v); }

        }

        students
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach((student) -> {
//                    double sum = student.getValue().stream().mapToDouble(i -> i).sum(); // not working in Judge
                    double sum = 0;
                    for (Double grade : student.getValue()) { sum += grade; }
                    double average = sum / student.getValue().size();
                    System.out.println(student.getKey() + " is graduated with " + average);
                });
    }
}