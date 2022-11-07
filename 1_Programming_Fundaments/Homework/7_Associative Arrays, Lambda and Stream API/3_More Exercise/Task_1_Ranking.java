import java.util.*;

public class Task_1_Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> contests = new LinkedHashMap<>();
        TreeMap<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        String input;

        while (!"end of contests".equals(input = scanner.nextLine())) {
            String[] token = input.split(":");

            contests.put(token[0], token[1]);
        }

        while (!"end of submissions".equals(input = scanner.nextLine())) {
            collect(input.split("=>"), contests, users);
        }

        printOut(users);
    }
    private static void collect (String[] input, LinkedHashMap<String, String> contests, TreeMap<String, LinkedHashMap<String, Integer>> users) {
        String contest = input[0];
        String userName = input[2];
        int userPoints = Integer.parseInt(input[3]);

        if (contests.containsKey(contest)) {
            if (contests.get(contest).equals(input[1])) {

                LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                course.put(contest, userPoints);

                if (!users.containsKey(userName)) {
                    users.put(userName, course);
                } else {
                    if (!users.get(userName).containsKey(contest)) {
                        users.get(userName).put(contest, userPoints);
                    } else {
                        users.get(userName).put(contest, Math.max(userPoints, users.get(userName).get(contest)));
                    }
                }
            }
        }
    }
    private static void printOut (TreeMap<String, LinkedHashMap<String, Integer>> users) {
        int bestPoints = 0;
        String bestName = "";
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : users.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > bestPoints) {
                bestPoints = sum;
                bestName = user.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestName, bestPoints);

        System.out.println("Ranking:");

        users.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });
    }
}