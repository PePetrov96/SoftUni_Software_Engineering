import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task_7_Merge_Two_Files {
    public static void main(String[] args) {
        String firstFile = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondFile = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String output = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (BufferedReader firstText = Files.newBufferedReader(Paths.get(firstFile));
             BufferedReader secondText = Files.newBufferedReader(Paths.get(secondFile));
             PrintWriter out = new PrintWriter(output)) {

            String line;
            while ((line = firstText.readLine()) != null) {
                out.println(line);
            }
            while ((line = secondText.readLine()) != null) {
                out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}