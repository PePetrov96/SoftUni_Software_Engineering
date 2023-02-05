import java.util.Scanner;

public class Task_1_Activation_Keys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String activationKey = scan.nextLine();
        String input;

        while (!"Generate".equals(input = scan.nextLine())) {
            String[] command = input.split(">>>");
            switch (command[0]) {
                case "Slice":
                    activationKey = activationKey.substring(0, Integer.parseInt(command[1]))
                            .concat(activationKey.substring(Integer.parseInt(command[2])));
                    System.out.println(activationKey);
                    break;
                case "Flip":
                    if (command[1].equals("Upper")) {
                        activationKey = activationKey.substring(0,Integer.parseInt(command[2]))
                                .concat(activationKey.substring(Integer.parseInt(command[2]),Integer.parseInt(command[3])).toUpperCase())
                                .concat(activationKey.substring(Integer.parseInt(command[3])));
                    } else {
                        activationKey = activationKey.substring(0,Integer.parseInt(command[2]))
                                .concat(activationKey.substring(Integer.parseInt(command[2]),Integer.parseInt(command[3])).toLowerCase())
                                .concat(activationKey.substring(Integer.parseInt(command[3])));
                    }
                    System.out.println(activationKey);
                    break;
                case "Contains":
                    if (activationKey.contains(command[1])) {
                        System.out.println(activationKey + " contains " + command[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
            }
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}