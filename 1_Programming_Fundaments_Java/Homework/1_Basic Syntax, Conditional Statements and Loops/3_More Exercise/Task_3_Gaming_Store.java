import java.util.Scanner;

public class Task_3_Gaming_Store {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();
        double spent = 0;

        while (!input.equals("Game Time")) {
            if (budget == spent) {
                System.out.println("Out of money!");
                break;
            }
            switch (input) {
                case "OutFall 4":
                    if ((spent + 39.99) > budget) {
                        System.out.println("Too Expensive");
                    } else {
                        spent += 39.99;
                        System.out.println("Bought OutFall 4");
                    }
                    break;
                case "CS: OG":
                    if ((spent + 15.99) > budget) {
                        System.out.println("Too Expensive");
                    } else {
                        spent += 15.99;
                        System.out.println("Bought CS: OG");
                    }
                    break;
                case "Zplinter Zell":
                    if ((spent + 19.99) > budget) {
                        System.out.println("Too Expensive");
                    } else {
                        spent += 19.99;
                        System.out.println("Bought Zplinter Zell");
                    }
                    break;
                case "Honored 2":
                    if ((spent + 59.99) > budget) {
                        System.out.println("Too Expensive");
                    } else {
                        spent += 59.99;
                        System.out.println("Bought Honored 2");
                    }
                    break;
                case "RoverWatch":
                    if ((spent + 29.99) > budget) {
                        System.out.println("Too Expensive");
                    } else {
                        spent += 29.99;
                        System.out.println("Bought RoverWatch");
                    }
                    break;
                case "RoverWatch Origins Edition":
                    if ((spent + 39.99) > budget) {
                        System.out.println("Too Expensive");
                    } else {
                        spent += 39.99;
                        System.out.println("Bought RoverWatch Origins Edition");
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, (budget - spent));
    }
}