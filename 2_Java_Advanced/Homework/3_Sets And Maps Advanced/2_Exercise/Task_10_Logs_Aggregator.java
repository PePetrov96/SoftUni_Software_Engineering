import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Task_10_Logs_Aggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, UserData> logList = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());

        for (int cycles = 0; cycles < n; cycles++) {
            updateEntries(logList, reader.readLine().split("\\s+"));
        }

        printOutput(logList);
    }
    private static void printOutput (TreeMap<String, UserData> logList) {
        logList
                .forEach((key1, value) -> System.out.printf("%s: %d %s%n"
                        , key1
                        , value.duration
                        , value.sortedIPs().toString()));
    }
    private static void updateEntries (TreeMap<String, UserData> logList, String[] input) {
        String IP = input[0];
        String user = input[1];
        int duration = Integer.parseInt(input[2]);

        UserData newUser = new UserData(0, new HashSet<>());

        if (!logList.containsKey(user)) {
            logList.put(user, newUser);
        }

        logList.get(user).duration += duration;
        logList.get(user).IPs.add(IP);
    }
    private static class UserData {
        int duration;
        HashSet<String> IPs;
        public UserData(int duration, HashSet<String> IPs) {
            this.duration = duration;
            this.IPs = IPs;
        }
        public List<String> sortedIPs() {
            return IPs.stream().sorted().collect(Collectors.toList());
        }
    }
}