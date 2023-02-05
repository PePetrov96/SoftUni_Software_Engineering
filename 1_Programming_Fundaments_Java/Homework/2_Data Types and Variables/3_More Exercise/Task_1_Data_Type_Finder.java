import java.util.Scanner;

public class Task_1_Data_Type_Finder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();

        while (!type.equals("END")) {
            Scanner input = new Scanner(type);
            if (input.hasNextBoolean()) {
                System.out.println(type + " is boolean type");
            } else if (input.hasNextInt()) {
                System.out.println(type + " is integer type");
            } else if (input.hasNextFloat()) {
                System.out.println(type + " is floating point type");
            } else if (type.length() == 1) {
                System.out.println(type + " is character type");
            } else {
                System.out.println(type + " is string type");
            }
            type = scan.nextLine();
        }
    }
}