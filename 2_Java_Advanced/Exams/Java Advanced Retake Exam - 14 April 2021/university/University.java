package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (students.contains(student)) {
            return "Student is already in the university";
        } else if (getStudentCount() >= getCapacity()) {
            return "No seats in the university";
        } else {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) &&
                student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        students.forEach(student ->
            out.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s"
                    , student.getFirstName(), student.getLastName(), student.getBestSubject()))
                    .append(System.lineSeparator()));

        return out.toString().trim();
    }
}