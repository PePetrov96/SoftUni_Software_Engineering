import java.util.Scanner;

public class Task_2_Common_Elements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] Array1 = scan.nextLine().split(" ");
        String[] Array2 = scan.nextLine().split(" ");
        String result = "";
        for (int i = 0; i < Array2.length; i++) {
            for (int j = 0; j < Array1.length; j++) {
                if (Array2[i].equals(Array1[j])) {
                    result = result + Array2[i] + " ";
                }
            }
        }
        System.out.println(result);
    }
}
