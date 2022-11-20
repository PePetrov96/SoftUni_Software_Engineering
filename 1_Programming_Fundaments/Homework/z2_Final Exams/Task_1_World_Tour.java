import java.util.Scanner;

public class Task_1_World_Tour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stops = scan.nextLine();
        String input;

        while (!"Travel".equals(input = scan.nextLine())) {
            stops = updateStops(input.split("\\s*:\\s*"), stops);
            System.out.println(stops);
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    private static String updateStops (String[] tokens, String stops) {
        switch (tokens[0]) {
            case "Add Stop":
                stops = addStop(stops, Integer.parseInt(tokens[1]), tokens[2]);
                break;
            case "Remove Stop":
                stops = removeStop(stops, Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;
            case "Switch":
                stops = switchStops(stops, tokens[1], tokens[2]);
                break;
        }
        return stops;
    }
    private static String addStop (String stops, int index, String place) {
        try {
            return stops.substring(0, index) + place + stops.substring(index);
        } catch (IndexOutOfBoundsException e) {
            return stops;
        }
    }
    private static String removeStop (String stops, int startIndex, int endIndex) {
        try {
            return stops.substring(0, startIndex) + stops.substring(endIndex+1);
        } catch (IndexOutOfBoundsException e) {
            return stops;
        }
    }
    private static String switchStops (String stops, String oldString, String newString) {
        if (stops.contains(oldString)) {
            return stops.replace(oldString, newString);
        } else {
            return stops;
        }
    }
}
