import java.util.Scanner;

public class Task_1_Student_Information {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Name: %s, Age: %d, Grade: %.2f", scan.nextLine(), scan.nextInt(), scan.nextDouble());
    }
}
