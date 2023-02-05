import java.util.Scanner;

public class Task_3_Longer_Line {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1=0, num2=0, num3=0, num4=0;
        double max = -9999999;
        for (int i = 0; i < 2; i++) {
            double n1 = Double.parseDouble(scan.nextLine());
            double n2 = Double.parseDouble(scan.nextLine());
            double n3 = Double.parseDouble(scan.nextLine());
            double n4 = Double.parseDouble(scan.nextLine());
            if (getCoordinates(n1, n2, n3, n4) > max) {
                max = getCoordinates(n1, n2, n3, n4);
                num1 = (int) n1;
                num2 = (int) n2;
                num3 = (int) n3;
                num4 = (int) n4;
            }
        }
        int[] print = (orderCoordinates(num1, num2, num3, num4));
        System.out.printf("(%d, %d)(%d, %d)", print[0], print[1], print[2], print[3]);
    }
    private static double getCoordinates (double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
    private static int[] orderCoordinates (int num1, int num2, int num3, int num4) {
        int[] order = new int[4];
        if ((Math.abs(num1) + Math.abs(num2)) < (Math.abs(num3) + Math.abs(num4))) {
            order[0] = num1; order[1] = num2; order[2] = num3; order[3] = num4;
        } else {
            order[0] = num3; order[1] = num4; order[2] = num1; order[3] = num2;
        }
        return order;
    }
}