import java.util.*;

public class Task_4_Students {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            Student student = new Student(input[0], input[1], Double.parseDouble(input[2]));
            studentList.add(student);
        }

        studentList.sort(Comparator.comparingDouble(Student::getGrade).reversed());
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
    public static class Student {
        private final String firstName;
        private final String secondName;
        private final double grade;
        public double getGrade() {
            return grade;
        }
        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", firstName, secondName, grade);
        }
    }
}