import java.util.Scanner;

public class Task_11_Rage_Expenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lostGames = Integer.parseInt(scan.nextLine());
        double headsetPrice = Double.parseDouble(scan.nextLine());
        double mousePrice = Double.parseDouble(scan.nextLine());
        double keyboardPrice = Double.parseDouble(scan.nextLine());
        double displayPrice = Double.parseDouble(scan.nextLine());

        int headsets = 0;
        int mouses = 0;
        int keyboards = 0;
        int displays = 0;
        int counter = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                headsets++;
            }
            if (i % 3 == 0) {
                mouses++;
            }
            if (i % 3 == 0 && i % 2 == 0) {
                keyboards++;
                counter++;
                if (counter % 2 == 0) {
                    displays++;
                }
            }
        }
        double expenses = (headsets * headsetPrice) + (mouses * mousePrice) + (keyboards * keyboardPrice) + (displays * displayPrice);
        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}