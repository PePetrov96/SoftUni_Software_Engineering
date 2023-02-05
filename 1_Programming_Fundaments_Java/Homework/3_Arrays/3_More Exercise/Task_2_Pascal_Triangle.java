import java.util.Scanner;
public class Task_2_Pascal_Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = Integer.parseInt(scan.nextLine());

        for (long line = 1; line <= n; line++) {
            long C = 1;
            for(long i = 1; i <= line; i++) {
                System.out.print(C + " ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }
}