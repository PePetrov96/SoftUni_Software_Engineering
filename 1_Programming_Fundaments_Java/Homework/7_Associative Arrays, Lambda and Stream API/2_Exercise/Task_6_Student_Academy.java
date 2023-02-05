import java.util.*;

public class Task_6_Student_Academy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> studentList = new LinkedHashMap<>();

        while (n-- > 0) {
            String name = scan.nextLine();
            if (!studentList.containsKey(name)) {
                studentList.put(name, new ArrayList<>());
            }
            studentList.get(name).add(Double.parseDouble(scan.nextLine()));
        }
        filterAndPrint(studentList);
    }
    private static double averageGrade (List<Double> grades) {
        double sumGrades = 0;
        for (Double grade : grades) {
            sumGrades += grade;
        }
        return sumGrades / grades.size();
    }

    private static void filterAndPrint (Map<String, List<Double>> studentList) {
        Map<String, Double> graduatedStudents = new LinkedHashMap<>();
        studentList.forEach((key, value) -> {
            if (averageGrade(value) >= 4.50) {
                graduatedStudents.put(key, averageGrade(value));
            }
        });
        graduatedStudents.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value));

    }
}
