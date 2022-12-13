import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task_6_Word_Count {
    public static void main(String[] args) {
        String wordsPath = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String textPath = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

        LinkedHashMap<String, Integer> occurrenceCounter = new LinkedHashMap<>();

        try (BufferedReader wordIn = Files.newBufferedReader(Paths.get(wordsPath));
        BufferedReader text = Files.newBufferedReader(Paths.get(textPath));
             PrintWriter out = new PrintWriter(outputPath)) {

            String[] wordsFromFile = wordIn.readLine().split("\\s+");

            for (String word : wordsFromFile) occurrenceCounter.putIfAbsent(word, 0);

            String line;

            while ((line = text.readLine()) != null) {
                String[] lineToWords = line.split("[.,!?]?\\s+");

                for (String s : lineToWords) {
                    for (String word : wordsFromFile) {
                        if (s.equals(word))
                            occurrenceCounter.put(word, occurrenceCounter.get(word) + 1);
                    }
                }

            }

            occurrenceCounter
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(key -> out.println(key.getKey() + " - " + key.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}