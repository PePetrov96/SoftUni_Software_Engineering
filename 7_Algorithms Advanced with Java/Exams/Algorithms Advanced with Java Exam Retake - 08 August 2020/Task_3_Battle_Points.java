import java.util.*;

public class Task_3_Battle_Points {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] energyInput = scanner.nextLine().split(" ");
        String[] pointsInput = scanner.nextLine().split(" ");
        int totalEnergy = scanner.nextInt();
        int enemiesCount = energyInput.length;

        int[] energy = new int[enemiesCount];
        int[] points = new int[enemiesCount];

        for (int i = 0; i < enemiesCount; i++) {
            energy[i] = Integer.parseInt(energyInput[i]);
            points[i] = Integer.parseInt(pointsInput[i]);
        }

        int[][] dp = new int[enemiesCount + 1][totalEnergy + 1];
        for (int i = 0; i <= enemiesCount; i++) {
            for (int j = 0; j <= totalEnergy; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (energy[i-1] <= j)
                    dp[i][j] = Math.max(points[i-1] + dp[i-1][j-energy[i-1]],  dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[enemiesCount][totalEnergy]);
    }
}
