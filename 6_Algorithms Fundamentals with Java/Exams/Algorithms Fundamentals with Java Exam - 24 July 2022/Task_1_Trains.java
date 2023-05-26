import java.util.Arrays;
import java.util.Scanner;

public class Task_1_Trains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        String[] arrivalTimesStr = scanner.nextLine().split("\\s+");
        String[] departureTimesStr = scanner.nextLine().split("\\s+");

        double[] arrivalTimes = new double[arrivalTimesStr.length];
        double[] departureTimes = new double[departureTimesStr.length];

        for (int i = 0; i < arrivalTimesStr.length; i++) {
            arrivalTimes[i] = Double.parseDouble(arrivalTimesStr[i]);
        }

        for (int i = 0; i < departureTimesStr.length; i++) {
            departureTimes[i] = Double.parseDouble(departureTimesStr[i]);
        }

        // Sort the arrays
        Arrays.sort(arrivalTimes);
        Arrays.sort(departureTimes);

        // Find the minimum number of platforms
        int minPlatforms = findMinimumPlatforms(arrivalTimes, departureTimes);

        // Print the result
        System.out.println(minPlatforms);

        scanner.close();
    }

    private static int findMinimumPlatforms(double[] arrivals, double[] departures) {
        int numPlatforms = 0;
        int maxPlatforms = 0;
        int i = 0;
        int j = 0;

        while (i < arrivals.length && j < departures.length) {
            if (arrivals[i] < departures[j]) {
                numPlatforms++;
                i++;
                maxPlatforms = Math.max(maxPlatforms, numPlatforms);
            } else {
                numPlatforms--;
                j++;
            }
        }

        return maxPlatforms;
    }
}
