import java.util.Scanner;

public class Task_9_Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfOrders = Integer.parseInt(scan.nextLine());
        double total = 0;

        for (int i = 1; i <= numberOfOrders; i++) {
            double currentOrder = 0;
            double pricePerCapsule = Double.parseDouble(scan.nextLine());
            int days = Integer.parseInt(scan.nextLine());
            int numberOfCapsules = Integer.parseInt(scan.nextLine());
            currentOrder = days * numberOfCapsules * pricePerCapsule;
            total += currentOrder;
            System.out.printf("The price for the coffee is: $%.2f%n", currentOrder);
        }
        System.out.printf("Total: $%.2f", total);
    }
}
