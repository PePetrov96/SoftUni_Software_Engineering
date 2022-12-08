import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task_9_Poisonous_Plants {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> pesticides = new LinkedHashMap<>(Integer.parseInt(consoleReader.readLine()));
        String[] input = consoleReader.readLine().split("\\s+"); consoleReader.close();

        for (int i = 0; i < input.length; i++) pesticides.put(i, Integer.parseInt(input[i]));

        int daysCounter = 0;
        List<Integer> plantsToRemove = new ArrayList<>();

        while (true) {
            Map.Entry<Integer, Integer> previousEntry = null;

            for (Map.Entry<Integer, Integer> currentEntry : pesticides.entrySet()) {
                if (previousEntry == null) {
                    previousEntry = currentEntry;
                    continue;
                }

                if (previousEntry.getValue() < currentEntry.getValue()) plantsToRemove.add(currentEntry.getKey());

                previousEntry = currentEntry;
            }

            if (plantsToRemove.isEmpty()) {
                break;
            }

            daysCounter++;

            for (Integer integer : plantsToRemove) pesticides.remove(integer);

            plantsToRemove.clear();
        }

        System.out.println(daysCounter);
    }
}