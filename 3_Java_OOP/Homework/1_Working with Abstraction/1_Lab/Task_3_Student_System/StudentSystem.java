import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void Create(String[] input) {
        String name = input[0];
        int age = Integer.parseInt(input[1]);
        double grade = Double.parseDouble(input[2]);

        if (!repo.containsKey(name)) {
            Student student = new Student(name, age, grade);
            repo.put(name,student);
        }
    }

    public void Show(String name) {
        if (repo.containsKey(name)) {
            Student student = repo.get(name);

            StringBuilder view = new StringBuilder(student.toString()).append(" ");

            if (student.getGrade() >= 5.00) {
                view.append("Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view.append("Average student.");
            } else {
                view.append("Very nice person.");
            }

            System.out.println(view);
        }
    }
}