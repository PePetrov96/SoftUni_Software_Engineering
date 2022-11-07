import java.util.*;

public class Task_4_Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> dwarfs = new LinkedHashMap<>();
        Map<String, Integer> dwarfCountByColor = new LinkedHashMap<>();
        String input;

        while (!"Once upon a time".equals(input = scanner.nextLine())) {
            addDwarf(dwarfCountByColor, dwarfs, input.split(" <:> "));
        }

        printResult(dwarfCountByColor, dwarfs);
    }
    private static void addDwarf (Map<String, Integer> dwarfCountByColor, Map<String, Integer> dwarfs, String[] input) {
        String dwarf = input[1] + " " + input[0];
        String color = input[1];
        int physics = Integer.parseInt(input[2]);

        dwarfCountByColor.putIfAbsent(color, 0);
        dwarfCountByColor.put(color, dwarfCountByColor.get(color) + 1);

        if (dwarfs.containsKey(dwarf)) {
            if (dwarfs.get(dwarf) < physics) {
                dwarfs.put(dwarf, physics);
                dwarfCountByColor.put(color, dwarfCountByColor.get(color) - 1);
            }
        }else {
            dwarfs.put(dwarf, physics);
        }
    }
    private static void printResult (Map<String, Integer> dwarfCountByColor, Map<String, Integer> dwarfs) {
        dwarfs.entrySet().stream().sorted((pair1, pair2) -> {
            int sort = Integer.compare(pair2.getValue(), pair1.getValue());
            if (sort == 0) {

                String[] color1 = pair1.getKey().split(" ");
                String[] color2 = pair2.getKey().split(" ");

                int size1 = dwarfCountByColor.get(color1[0]);
                int size2 = dwarfCountByColor.get(color2[0]);
                sort = Integer.compare(size2, size1);
            }
            return sort;
        }).forEach(pair -> {
            String[] print = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d\n", print[0], print[1], pair.getValue());
        });
    }
}