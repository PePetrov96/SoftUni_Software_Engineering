import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Task_4_Set_Cover {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] universe = Arrays.stream(reader.readLine().substring(10).split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));

        List<int[]> sets = new ArrayList<>();

        for (int i = 0; i < numberOfSets; i++) {
            int[] set = Arrays.stream(reader.readLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            sets.add(set);
        }

        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("[\\[\\]]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> selectedSets = new ArrayList<>();
        Set<Integer> universeSet = new HashSet<>();

        for (int element : universe) { universeSet.add(element); }

        while (!universeSet.isEmpty()) {
            int notChosenCount = 0;
            int[] chosenSet = sets.get(0);

            for (int[] set : sets) {
                int count = 0;

                for (int element : set) {
                    if (universeSet.contains(element)) {
                        count++;
                    }
                }

                if (notChosenCount < count) {
                    notChosenCount = count;
                    chosenSet = set;
                }
            }

            selectedSets.add(chosenSet);

            for (int element : chosenSet) {
                universeSet.remove(element);
            }
        }

        return selectedSets;
    }
}