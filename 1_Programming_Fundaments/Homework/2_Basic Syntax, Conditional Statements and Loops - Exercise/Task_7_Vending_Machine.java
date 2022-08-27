import java.util.Scanner;

public class Task_7_Vending_Machine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double inserted;
        double totalInserted = 0;

        while (!input.equals("Start")) {
            inserted = Double.parseDouble(input);
            if (inserted == 0.1 || inserted == 0.2 || inserted == 0.5 || inserted == 1 || inserted == 2){
                totalInserted += inserted;
            } else {
                System.out.printf("Cannot accept %.2f%n", inserted);
            }
            input = scan.nextLine();
        }
        double totalSpent = 0;

        input = scan.nextLine();

        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    if ((totalSpent + 2.0) <= totalInserted) {
                        totalSpent += 2.0;
                        System.out.println("Purchased Nuts");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if ((totalSpent + 0.70) <= totalInserted) {
                        totalSpent += 0.70;
                        System.out.println("Purchased Water");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if ((totalSpent + 1.50) <= totalInserted) {
                        totalSpent += 1.50;
                        System.out.println("Purchased Crisps");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if ((totalSpent + 0.80) <= totalInserted) {
                        totalSpent += 0.80;
                        System.out.println("Purchased Soda");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if ((totalSpent + 1.0) <= totalInserted) {
                        totalSpent += 1.0;
                        System.out.println("Purchased Coke");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Change: %.2f", (totalInserted - totalSpent));
    }
}