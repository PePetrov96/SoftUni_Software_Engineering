import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_2_Sum_Bytes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader in = Files.newBufferedReader(Paths.get(inputPath))) {
            long sum = 0;
            String line;
            while ((line = in.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
