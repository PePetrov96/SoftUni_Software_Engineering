import java.util.*;

public class Task_5_Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String[] input = scan.nextLine().split(" : ");

        while (!input[0].equals("end")) {
            if (!courses.containsKey(input[0])) {
                courses.put(input[0], new ArrayList<>());
            }
            courses.get(input[0]).add(input[1]);

            input = scan.nextLine().split(" : ");
        }
        courses.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, value.size());
            value.forEach(studentName -> System.out.printf("-- %s%n", studentName));
        });
    }
}