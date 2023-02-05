import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Task_2_Judge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> userList = new LinkedHashMap<>();
        String input;

        while (!"no more time".equals(input = scan.nextLine())) {
            updateList(input.split(" -> "), userList);
        }

        printResults(userList);
    }
    public static void updateList (String[] token, Map<String, LinkedHashMap<String, Integer>> userList) {
        String userName = token[0];
        String contestName = token[1];
        int userPoints = Integer.parseInt(token[2]);

        if (!userList.containsKey(contestName)) {
            userList.put(contestName, new LinkedHashMap<>());
            userList.get(contestName).put(userName, userPoints);
        } else {
            if (userList.get(contestName).containsKey(userName)) {
                if (userList.get(contestName).get(userName) < userPoints) {
                    userList.get(contestName).put(userName, userPoints);
                }
            } else {
                userList.get(contestName).put(userName, userPoints);
            }
        }
    }
    public static void printResults (Map<String, LinkedHashMap<String, Integer>> userList) {
        AtomicInteger num = new AtomicInteger();

        userList.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());
            num.set(1);
            Map<String, Integer> students;
            students = value;
            students.entrySet().stream()
                    .sorted((e1, e2) -> {
                        if (e2.getValue().equals(e1.getValue())) {
                            return e1.getKey().compareTo(e2.getKey());
                        } else {
                            return e2.getValue() - e1.getValue();
                        }
                    })
                    .forEach((s) -> System.out.printf("%d. %s <::> %d%n", num.getAndIncrement(), s.getKey(), s.getValue()));

        });


        Map<String, Integer> standings = new LinkedHashMap<>();

        for(Map.Entry<String, LinkedHashMap<String, Integer>> entry : userList.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                standings.putIfAbsent(subEntry.getKey(), 0);
                standings.put(subEntry.getKey(), standings.get(subEntry.getKey()) + subEntry.getValue());
            }
        }
        System.out.println("Individual standings:");
        num.set(1);

        standings.entrySet().stream().sorted((e2, e1) -> {
            int sort = Integer.compare(e1.getValue(), e2.getValue());
            if (sort == 0) {
                sort = e2.getKey().compareTo(e1.getKey());
            }
            return sort;
        }).forEach(element -> System.out.printf("%d. %s -> %d\n", num.getAndIncrement(), element.getKey(), element.getValue()));
    }
}