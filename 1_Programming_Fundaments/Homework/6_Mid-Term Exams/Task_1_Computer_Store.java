import java.util.Scanner;

public class Task_1_Computer_Store {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double cost = 0;
        boolean isSpecial = false;

        while (true) {
            if (input.equals("regular")) {
                break;
            } else if (input.equals("special")) {
                isSpecial = true;
                break;
            }

            double price = Double.parseDouble(input);
            if (price <= 0) {
                System.out.println("Invalid price!");
                input = scan.nextLine();
                continue;
            } else {
                cost += price;
            }

            input = scan.nextLine();
        }

        double totalCost;
        if (isSpecial) {
            totalCost = (cost * 1.2) * 0.9;
        } else {
            totalCost = (cost * 1.2);
        }

        if (cost <= 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", cost);
            System.out.printf("Taxes: %.2f$%n", (cost * 0.2));
            System.out.printf("-----------%n");
            System.out.printf("Total price: %.2f$", totalCost);
        }
    }
}