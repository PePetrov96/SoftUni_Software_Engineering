import java.io.File;
import java.util.ArrayDeque;
import java.util.Objects;

public class Task_8_Get_Folder_Size {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Petrov\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        ArrayDeque<File> files = new ArrayDeque<>();

        files.offer(file);

        long bytes = 0;

        while (!files.isEmpty()) {
            File current = files.poll();
            for (File fileCheck : Objects.requireNonNull(current.listFiles())) {
                if (fileCheck.isDirectory()) {
                    files.offer(fileCheck);
                } else {
                    bytes += fileCheck.length();
                }
            }
        }
        System.out.println("Folder size: " + bytes);
    }
}