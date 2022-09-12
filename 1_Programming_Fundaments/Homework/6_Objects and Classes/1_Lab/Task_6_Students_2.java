import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_6_Students_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Task_6_Students_2> students = new ArrayList<>();

        String line = scan.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String town = tokens[3];

            if (IsStudentExisting(students, firstName, lastName)) {
                Task_6_Students_2 student = getStudent(students, firstName, lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setTown(town);
            } else {
                Task_6_Students_2 student = new Task_6_Students_2(firstName, lastName, age, town);
                students.add(student);
            }

            line = scan.nextLine();
        }
        String filterTown = scan.nextLine();

        for (Task_6_Students_2 student : students) {
            if (student.getTown().equals(filterTown)) {
                System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLastName(), student.getAge(), student.getTown());
            }
        }
    }
    private static Task_6_Students_2 getStudent (List<Task_6_Students_2> students, String firstName, String lastName) {
        Task_6_Students_2 existingStudent = null;

        for (Task_6_Students_2 student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }
    private static boolean IsStudentExisting (List<Task_6_Students_2> students, String firstName, String lastName) {
        for (Task_6_Students_2 student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
    private String firstName;
    private String lastName;
    private int age;
    private String town;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
    public Task_6_Students_2(String firstName, String lastName, int age, String town) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.town = town;
    }
}