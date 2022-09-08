import java.util.Scanner;

public class Task_1_Data_Types {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        String input = scan.nextLine();
        switch (type) {
            case "int":
                getInt(input);
                break;
            case "real":
                getDouble(input);
                break;
            case "string":
                getString(input);
                break;
        }

    }
    private static void getInt (String input) {
        int n = Integer.parseInt(input);
        System.out.println(n * 2);
    }
    private static void getDouble (String input) {
        double n = Double.parseDouble(input);
        System.out.printf("%.2f", (n * 1.50));
    }
    private static void getString (String input) {
        System.out.println("$" + input + "$");
    }
}