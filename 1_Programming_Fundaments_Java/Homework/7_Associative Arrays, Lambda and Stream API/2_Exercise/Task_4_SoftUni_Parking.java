import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task_4_SoftUni_Parking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            if (input[0].equals("register")) {
                register(users, input);
            } else if (input[0].equals("unregister")) {
                unregister(users, input);
            }
        }

        users.forEach((key, value) -> System.out.printf("%s => %s%n", key, value));
    }
    private static void register (LinkedHashMap<String, String> users, String[] input) {
        if (!users.containsKey(input[1])) {
            users.put(input[1], input[2]);
            System.out.printf("%s registered %s successfully%n", input[1], input[2]);
        } else {
            System.out.printf("ERROR: already registered with plate number %s%n", users.get(input[1]));
        }
    }
    private static void unregister (LinkedHashMap<String, String> users, String[] input) {
        if (!users.containsKey(input[1])) {
            System.out.printf("ERROR: user %s not found%n", input[1]);
        } else {
            users.remove(input[1]);
            System.out.printf("%s unregistered successfully%n", input[1]);
        }
    }
}