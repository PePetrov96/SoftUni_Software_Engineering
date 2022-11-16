import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_2_Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        Map<String, Integer> participants = new LinkedHashMap<>();
        String[] names = scan.nextLine().split(", ");
        Arrays.stream(names).forEach(n -> participants.put(n,0));

        String input;

        while (!"end of race".equals(input = scan.nextLine())){
            updateEntry(input, participants);
        }
        resultOutput(participants);
    }
    private static void updateEntry (String input, Map<String, Integer> participants) {
        String name = input.replaceAll("[^A-Za-z]", "");

        if (participants.containsKey(name)){
            String numberStr = input.replaceAll("[^0-9]", "");

            for (int i = 0; i < numberStr.length(); i++) {
                int digit = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
                participants.put(name, participants.get(name) + digit);
            }
        }
    }

    private static void resultOutput (Map<String, Integer> participants) {
        final int[] i = {1};
        participants.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(3).forEach(n -> {
            switch (i[0]) {
                case 1: System.out.print("1st place: "); break;
                case 2: System.out.print("2nd place: "); break;
                case 3: System.out.print("3rd place: "); break;
            }
            System.out.println(n.getKey());
            i[0]++;
        });
    }
}