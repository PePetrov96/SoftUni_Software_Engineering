import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task_8_User_Logs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, LinkedHashMap<String, Integer>> messageLog = new TreeMap<>();

        String input;

        while (!"end".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String IP = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];

            if (!messageLog.containsKey(username)) {
                messageLog.put(username, new LinkedHashMap<>());
            }

            if (!messageLog.get(username).containsKey(IP)) {
                messageLog.get(username).put(IP, 0);
            }

            messageLog.get(username).put(IP, messageLog.get(username).get(IP) + 1);
        }

        messageLog
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(key -> {
                    System.out.println(key.getKey() + ":");
                    System.out.print(key.getValue().toString().replaceAll("[\\[\\]{}]","").replaceAll("="," => "));
                    System.out.print(".");
                    System.out.println();
                });
    }
}