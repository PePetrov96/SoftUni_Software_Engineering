import java.util.Scanner;

public class Task_3_Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(sc.nextLine());
        String typeOfGroup = sc.nextLine();
        String dayOfTheWeek = sc.nextLine();

        double nightCost = 0;

        switch (typeOfGroup) {
            case "Students":
                if (dayOfTheWeek.equals("Friday")) {
                    nightCost = 8.45;
                } else if (dayOfTheWeek.equals("Saturday")) {
                    nightCost = 9.80;
                } else if (dayOfTheWeek.equals("Sunday")) {
                    nightCost = 10.46;
                }
                break;
            case "Business":
                if (dayOfTheWeek.equals("Friday")) {
                    nightCost = 10.90;
                } else if (dayOfTheWeek.equals("Saturday")) {
                    nightCost = 15.60;
                } else if (dayOfTheWeek.equals("Sunday")) {
                    nightCost = 16;
                }
                break;
            case "Regular":
                if (dayOfTheWeek.equals("Friday")) {
                    nightCost = 15;
                } else if (dayOfTheWeek.equals("Saturday")) {
                    nightCost = 20;
                } else if (dayOfTheWeek.equals("Sunday")) {
                    nightCost = 22.50;
                }
                break;
        }
        double totalCost;

        if (typeOfGroup.equals("Students") && numberOfPeople >= 30) {
            totalCost = (nightCost * numberOfPeople) * 0.85;
        } else if (typeOfGroup.equals("Business") && numberOfPeople >= 100) {
            totalCost = (nightCost * numberOfPeople) - (nightCost * 10);
        } else if (typeOfGroup.equals("Regular") && numberOfPeople >= 10 && numberOfPeople <= 20) {
            totalCost = (nightCost * numberOfPeople) * 0.95;
        } else {
            totalCost = (nightCost * numberOfPeople);
        }
        System.out.printf("Total price: %.2f", totalCost);
    }
}
