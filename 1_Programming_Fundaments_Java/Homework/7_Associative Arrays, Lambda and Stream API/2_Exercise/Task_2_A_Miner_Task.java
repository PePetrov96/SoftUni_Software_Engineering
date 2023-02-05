import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task_2_A_Miner_Task {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> elements = new LinkedHashMap<>();

        String material;
        while (!"stop".equals(material = scan.nextLine())) {
            String amount = scan.nextLine();
            if (!elements.containsKey(material)) {
                elements.put(material, Integer.parseInt(amount));
            } else {
                elements.put(material, elements.get(material) + Integer.parseInt(amount));
            }
        }

        elements.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}