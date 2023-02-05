import java.util.Scanner;

public class Task_3_Extract_File {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] file = scan.nextLine().split("\\\\");
        String[] result = file[file.length-1].split("\\.");
        System.out.printf("File name: %s%n"+
                "File extension: %s", result[0], result[1]);
    }
}