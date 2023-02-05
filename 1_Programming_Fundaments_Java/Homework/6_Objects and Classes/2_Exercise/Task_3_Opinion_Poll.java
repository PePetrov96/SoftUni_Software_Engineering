import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3_Opinion_Poll {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            peopleList.add(person);
        }

        for (Person person : peopleList) {
            if (person.getAge() > 30) {
                System.out.println(person);
            }
        }

    }
    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s - %s", name, age);
        }
    }
}