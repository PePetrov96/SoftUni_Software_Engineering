import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_5_Students {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Task_5_Students> students = new ArrayList<>();

        String line = scan.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String town = tokens[3];

            Task_5_Students student = new Task_5_Students(firstName, lastName, age, town);

            students.add(student);
            line = scan.nextLine();
        }
        String filterTown = scan.nextLine();

        for (Task_5_Students student : students) {
            if (student.getTown().equals(filterTown)) {
                System.out.printf("%s %s is %d years old\n", student.getFirstName(), student.getLastName(), student.getAge(), student.getTown());
            }
        }
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

    public Task_5_Students(String firstName, String lastName, int age, String town) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.town = town;
    }
}