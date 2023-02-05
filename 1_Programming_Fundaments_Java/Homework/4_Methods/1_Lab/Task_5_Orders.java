import java.util.Scanner;

public class Task_5_Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        orders(scan.nextLine(), Integer.parseInt(scan.nextLine()));
    }
    private static void orders (String order, int amount) {
        switch (order) {
            case "coffee":
                System.out.printf("%.2f", amount * 1.50);
                break;
            case "water":
                System.out.printf("%.2f", amount * 1.0);
                break;
            case "coke":
                System.out.printf("%.2f", amount * 1.40);
                break;
            case "snacks":
                System.out.printf("%.2f", amount * 2.0);
                break;
        }
    }
}