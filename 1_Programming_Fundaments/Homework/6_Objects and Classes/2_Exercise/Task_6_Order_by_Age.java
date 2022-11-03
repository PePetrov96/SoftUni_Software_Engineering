import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Task_6_Order_by_Age {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        List<People> peopleList = new ArrayList<>();

        while (!input[0].equals("End")) {
            People person = new People(input[0], input[1], Integer.parseInt(input[2]));
            peopleList.add(person);
            input = scan.nextLine().split("\\s+");
        }

        peopleList.sort(Comparator.comparingInt(People::getAge));
        peopleList.forEach(System.out::println);
    }
    public static class People {
        private final String name;
        private final String ID;
        private final int age;

        public People(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %s years old.", name, ID, age);
        }
    }
}