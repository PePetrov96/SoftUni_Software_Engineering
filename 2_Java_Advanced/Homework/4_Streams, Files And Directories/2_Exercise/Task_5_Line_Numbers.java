import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_5_Line_Numbers {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter out = new PrintWriter(outputPath)) {
            int count = 1;
            String line;
            while ((line = in.readLine()) != null) {
                out.println(count + ". " + line);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
