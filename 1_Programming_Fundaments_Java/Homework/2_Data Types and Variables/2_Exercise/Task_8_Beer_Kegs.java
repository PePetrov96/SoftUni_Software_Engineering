import java.util.Scanner;

public class Task_8_Beer_Kegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String biggestKeg = "";
        double max = Double.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            double volume = 0;
            String kegName = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            volume = Math.PI * (radius * radius) * height;
            if (volume > max) {
                biggestKeg = kegName;
                max = volume;
            }
        }
        System.out.println(biggestKeg);
    }
}