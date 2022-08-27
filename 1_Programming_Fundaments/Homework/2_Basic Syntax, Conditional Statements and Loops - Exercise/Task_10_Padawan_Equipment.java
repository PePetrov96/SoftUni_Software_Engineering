import java.util.Scanner;

public class Task_10_Padawan_Equipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int numOfStudents = Integer.parseInt(scan.nextLine());
        double lightsaberCost = Double.parseDouble(scan.nextLine());
        double robeCost = Double.parseDouble(scan.nextLine());
        double beltCost = Double.parseDouble(scan.nextLine());

        int freebelts = 0;

        for (int i = 1; i <= numOfStudents; i++) {
            if (i % 6 == 0) {
                freebelts++;
            }
        }

        double totalCost = (Math.ceil((numOfStudents * 1.10)) * lightsaberCost) + (numOfStudents * robeCost) + ((numOfStudents - freebelts) * beltCost);

        if (totalCost <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalCost);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalCost - budget);
        }
    }
}
