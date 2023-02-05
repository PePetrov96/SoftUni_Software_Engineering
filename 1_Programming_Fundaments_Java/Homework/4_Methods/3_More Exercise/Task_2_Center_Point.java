import java.util.Scanner;

public class Task_2_Center_Point {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = Integer.parseInt(scan.nextLine());
        int n2 = Integer.parseInt(scan.nextLine());
        int n3 = Integer.parseInt(scan.nextLine());
        int n4 = Integer.parseInt(scan.nextLine());

        if (getCoordinates(n1, n2) < getCoordinates(n3, n4)) {
            System.out.printf("(%d, %d)",n1, n2);
        } else {
            System.out.printf("(%d, %d)",n3, n4);
        }

    }
    private static int getCoordinates (int n1, int n2) {
        int number1 = Math.abs(n1);
        int number2 = Math.abs(n2);
        return number1 + number2;
    }
}