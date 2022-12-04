import java.util.Scanner;

public class Task_1_World_Tour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stops = scan.nextLine();

        String input;

        while (!"Travel".equals(input = scan.nextLine())) {
            String[] commands = input.split("\\s*:\\s*");
            switch (commands[0]) {
                case "Add Stop":
                    stops = addStops(stops, Integer.parseInt(commands[1]), commands[2]); break;
                case "Remove Stop":
                    stops = removeStops(stops, Integer.parseInt(commands[1]), Integer.parseInt(commands[2])); break;
                case "Switch":
                    stops = switchStops(stops, commands[1], commands[2]); break;
            }

            System.out.println(stops);
        }

        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    private static String addStops (String stops, int index, String text) {
        try {
            return stops = stops.substring(0, index).concat(text).concat(stops.substring(index));
        } catch (IndexOutOfBoundsException e) {
            return stops;
        }
    }
    private static String removeStops (String stops, int start, int end) {
        try {
            return stops = stops.substring(0, start).concat(stops.substring(end+1));
        } catch (IndexOutOfBoundsException e) {
            return stops;
        }
    }
    private static String switchStops (String stops, String oldStr, String newStr) {
        if (stops.contains(oldStr)) {
            return stops.replace(oldStr, newStr);
        } else {
            return stops;
        }
    }
}