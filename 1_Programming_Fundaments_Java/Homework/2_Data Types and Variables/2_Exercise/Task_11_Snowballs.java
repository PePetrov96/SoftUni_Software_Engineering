import java.util.Scanner;

public class Task_11_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        double max = 0;
        String result = "";

        for (int i = 1; i <= numberOfSnowballs; i++) {
            double quality;
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            quality = Math.pow(((double) snowballSnow / snowballTime), snowballQuality);

            if (quality > max) {
                max = quality;
                result = String.format("%d : %d = %.0f (%d)", snowballSnow, snowballTime, max, snowballQuality);
            }
        }
        System.out.println(result);
    }
}