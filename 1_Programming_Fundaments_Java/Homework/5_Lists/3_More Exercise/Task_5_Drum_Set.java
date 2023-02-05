import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task_5_Drum_Set {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        int[] original = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> trackingCurrent = new ArrayList<>();
        for (int j : original) {
            trackingCurrent.add(j);
        }
        String input = scan.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int hit = Integer.parseInt(input);
            for (int i = 0; i < trackingCurrent.size(); i++) {
                trackingCurrent.set(i, (trackingCurrent.get(i) - hit));
                if (trackingCurrent.get(i) <= 0 && (savings - (original[i] * 3) > 0)) {
                    trackingCurrent.set(i, original[i]);
                    savings = savings - (original[i] * 3);
                }
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < trackingCurrent.size(); i++) {
            if (trackingCurrent.get(i) <= 0) {
                trackingCurrent.remove(i);
                i--;
            }
        }
        System.out.println(trackingCurrent.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}