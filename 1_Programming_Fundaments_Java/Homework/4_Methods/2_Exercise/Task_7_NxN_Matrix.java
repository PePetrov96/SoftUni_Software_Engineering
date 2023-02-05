import java.util.Scanner;

public class Task_7_NxN_Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(Line(n));
        }
    }
    public static String Line (int number) {
        String line = "";
        for (int i = 0; i < number; i++) {
            line = line + number + " ";
        }
        return line;
    }
}