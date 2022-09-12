import java.util.Scanner;

public class Task_1_Bonus_Scoring_System {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        int lectures = Integer.parseInt(scan.nextLine());
        int bonus = Integer.parseInt(scan.nextLine());
        int max = Integer.MIN_VALUE;
        double bestBonus = 0;

        if (students == 0 || lectures == 0) {
            System.out.println("Max Bonus: 0.");
            System.out.println("The student has attended 0 lectures.");
        } else {
            for (int i = 0; i < students; i++) {
                int input = Integer.parseInt(scan.nextLine());

                if (input > max) {
                    max = input;
                    bestBonus = Math.ceil(((double) input / (double) lectures) * (5 + bonus));
                }
            }
            System.out.printf("Max Bonus: %.0f.%n", bestBonus);
            System.out.println("The student has attended " + max + " lectures.");
        }
    }
}