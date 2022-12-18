import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            modifyList(list, input.split("\\s+"));
        }
    }
    public static void modifyList(CustomList<String> list, String[] command) {
        switch (command[0]) {
            case "Add":
                list.add(command[1]);
                break;
            case "Remove":
                list.remove(Integer.parseInt(command[1]));
                break;
            case "Contains":
                System.out.println(list.contains(command[1]));
                break;
            case "Swap":
                list.swap(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                break;
            case "Greater":
                System.out.println(list.sumOfGreater(command[1]));
                break;
            case "Max":
                System.out.println(list.getMax());
                break;
            case "Min":
                System.out.println(list.getMin());
                break;
            case "Print":
                list.printListToString();
                break;
        }
    }
}