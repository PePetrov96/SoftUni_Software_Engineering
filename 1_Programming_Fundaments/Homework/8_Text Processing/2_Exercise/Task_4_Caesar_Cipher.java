import java.util.Scanner;

public class Task_4_Caesar_Cipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder(scan.nextLine());

        for (int i = 0; i < result.length(); i++) {
            result.replace(i, i+1, ((char) (result.charAt(i) + 3) + ""));
        }

        System.out.println(result);
    }
}