import java.util.Arrays;
import java.util.Scanner;

public class Task_2_The_Lift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        int[] wagon = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        output(people, wagon);
    }
    private static void output (int people, int[] wagon) {
        for (int i = 0; i < wagon.length; i++) {
            if (people >= 4 - wagon[i]) {
                people -= 4 - wagon[i];
                wagon[i] = 4;
            } else {
                wagon[i] += people;
                people = 0;
            }
        }
        boolean wagonsNotFull = false;

        for (int i = 0; i < wagon.length; i++) {
            if (wagon[i] != 4) {
                wagonsNotFull = true;
                break;
            }
        }
        if (wagonsNotFull && people == 0) {
            System.out.println("The lift has empty spots!");
            System.out.println(Arrays.toString(wagon).replaceAll("[\\[\\],]", ""));
        } else if (people > 0 && !wagonsNotFull){
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            System.out.println(Arrays.toString(wagon).replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println(Arrays.toString(wagon).replaceAll("[\\[\\],]", ""));
        }
    }
}