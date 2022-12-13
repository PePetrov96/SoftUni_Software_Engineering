import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_12_Srabsko_Unleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Map<String, Long>> concertRoad = new LinkedHashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            updateEntry(concertRoad, input);
        }

        printResult(concertRoad);
    }
    private static void printResult (LinkedHashMap<String, Map<String, Long>> concertRoad) {
        concertRoad
                .forEach((key, value) -> {
                    System.out.println(key);
                    value
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(key1 -> System.out.printf("#  %s -> %d%n", key1.getKey(), key1.getValue()));
                });
    }
    private static void updateEntry (LinkedHashMap<String, Map<String, Long>> concertRoad, String input) {
        Pattern p = Pattern.compile("^(?<singer>[a-zA-Z]+ ?[a-zA-Z]* ?[a-zA-Z]*) @(?<venue>[a-zA-Z]+ ?[a-zA-Z]* ?[a-zA-Z]*) (?<ticketPrice>\\d+) (?<ticketCount>\\d+)$");
        Matcher m = p.matcher(input);

        if(m.find()){
            String singer = m.group("singer");
            String venue = m.group("venue");
            int ticketPrice = Integer.parseInt(m.group("ticketPrice"));
            int ticketCount = Integer.parseInt(m.group("ticketCount"));
            long profit = (long) ticketCount * ticketPrice;

            if (!concertRoad.containsKey(venue)) {
                concertRoad.put(venue, new LinkedHashMap<>());
            }

            if(!concertRoad.get(venue).containsKey(singer)){
                concertRoad.get(venue).put(singer, 0L);
            }

            concertRoad.get(venue).replace(singer, concertRoad.get(venue).get(singer)+profit);
        }
    }
}