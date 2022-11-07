import java.util.*;

public class Task_10_SoftUni_Exam_Results {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> userPoints = new HashMap<>();
        Map<String, Integer> languageCount = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {
            updateLists(userPoints, languageCount, input);
            input = scanner.nextLine();
        }
        printResult(userPoints, languageCount);
    }
    private static void updateLists (Map<String, Integer> userPoints, Map<String, Integer> languageCount, String input) {
        String[] splitArray = input.split("-");
        String username = splitArray[0];
        if (splitArray.length == 3) {
            String language = splitArray[1];
            int points = Integer.parseInt(splitArray[2]);
            if (!userPoints.containsKey(username)) {
                userPoints.put(username, points);
            } else {
                int currentPoints = userPoints.get(username);
                if (points > currentPoints) {
                    userPoints.put(username, points);
                }
            }

            if (!languageCount.containsKey(language)) {
                languageCount.put(language, 1);
            } else {
                languageCount.put(language, languageCount.get(language) + 1);
            }

        } else {
            userPoints.remove(username);
        }
    }
    private static void printResult (Map<String, Integer> userPoints, Map<String, Integer> languageCount) {
        System.out.println("Results:");
        userPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));

        System.out.println("Submissions:");
        languageCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}