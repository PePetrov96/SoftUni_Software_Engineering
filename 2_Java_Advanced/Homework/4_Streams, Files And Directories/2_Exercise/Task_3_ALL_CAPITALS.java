import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_3_ALL_CAPITALS {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter out = new PrintWriter(outputPath)) {
            String line = in.readLine();
            while (line != null) {
                out.println(line.toUpperCase());
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
