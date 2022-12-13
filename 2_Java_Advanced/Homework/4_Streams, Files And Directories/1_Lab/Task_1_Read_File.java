import java.io.FileInputStream;
import java.io.IOException;

public class Task_1_Read_File {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)){
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}