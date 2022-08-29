import java.util.Scanner;

public class Task_10_Poke_Mon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int targetCount = 0;
        int remainingPower = pokePower;

        while (remainingPower >= distance) {
            remainingPower -= distance;
            targetCount++;
            if (remainingPower == (pokePower * 0.50) && exhaustionFactor != 0) {
                remainingPower /= exhaustionFactor;
            }
        }
        System.out.println(remainingPower);
        System.out.println(targetCount);
    }
}
