import java.util.*;

public class Task_9_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            updateMap(map, input);
            input = scanner.nextLine();
        }
        printResult(map);
    }
    private static void updateMap (Map<String, List<String>> map, String input) {
        if (input.contains(" | ")) {
            String group = input.split("\\s+\\|\\s+")[0];
            String user = input.split("\\s+\\|\\s+")[1];
            if (!map.containsKey(group)) {
                map.put(group, new ArrayList<>());
            }
            boolean isExistUser = false;
            for (List<String> listUsers : map.values()) {
                if (listUsers.contains(user)) {
                    isExistUser = true;
                    break;
                }
            }

            if (!isExistUser) {
                map.get(group).add(user);
            }
        } else if (input.contains(" -> ")) {
            String user = input.split("\\s+->\\s+")[0];
            String group = input.split("\\s+->\\s+")[1];

            map.entrySet().forEach(entry -> entry.getValue().remove(user));

            if (map.containsKey(group)) {
                map.get(group).add(user);
            } else {
                map.put(group, new ArrayList<>());
                map.get(group).add(user);
            }

            System.out.printf("%s joins the %s side!%n", user, group);
        }
    }
    private static void printResult (Map<String, List<String>> map) {
        map.entrySet()
                .stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                            entry.getValue().forEach(user -> System.out.println("! " + user));
                        }
                );
    }
}