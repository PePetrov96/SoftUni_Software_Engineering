import java.util.Scanner;

public class Task_1_Activation_Keys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String activationKey = scan.nextLine();
        String input;

        while (!"Generate".equals(input = scan.nextLine())) {
            String[] tokens = input.split(">>>");

            switch (tokens[0]) {
                case "Contains":
                    if (activationKey.contains(tokens[1])) {
                        System.out.println(activationKey + " contains " + tokens[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int start = Integer.parseInt(tokens[2]);
                    int end = Integer.parseInt(tokens[3]);
                    if (tokens[1].equals("Upper")) {
                        activationKey = activationKey.substring(0, start) + activationKey.substring(start, end).toUpperCase() + activationKey.substring(end);
                    } else if (tokens[1].equals("Lower")) {
                        activationKey = activationKey.substring(0, start) + activationKey.substring(start, end).toLowerCase() + activationKey.substring(end);
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    activationKey = activationKey.substring(0, Integer.parseInt(tokens[1])) +
                            activationKey.substring(Integer.parseInt(tokens[2]));
                    System.out.println(activationKey);
                    break;
            }
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}