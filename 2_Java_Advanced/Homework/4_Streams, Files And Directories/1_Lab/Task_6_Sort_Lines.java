import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task_6_Sort_Lines {
    public static void main(String[] args) {
        Path inPath = Paths.get("C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path outPath = Paths.get("C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");

        try {
            List<String> lines = Files.readAllLines(inPath);
            lines = lines
                    .stream()
                    .filter(l -> !l.isBlank())
                    .collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(outPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}