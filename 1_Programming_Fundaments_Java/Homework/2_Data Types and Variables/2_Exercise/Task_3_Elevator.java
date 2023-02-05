import java.util.Scanner;

public class Task_3_Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numPeople = Integer.parseInt(scan.nextLine());
        int elevatorCapacity = Integer.parseInt(scan.nextLine());
        int result = (int) Math.ceil((double) numPeople / elevatorCapacity);
        System.out.println(result);
    }
}