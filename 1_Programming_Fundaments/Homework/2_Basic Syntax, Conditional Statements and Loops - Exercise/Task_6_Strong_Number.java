import java.util.Scanner;

public class Task_6_Strong_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fact_n, lastDig;
        int n = Integer.parseInt(scan.nextLine());
        int total = 0;
        int temp_n = n;

        while (n != 0) {
            int i = 1;
            fact_n = 1;
            lastDig = n % 10;

            while (i <= lastDig) {
                fact_n *= i;
                i++;
            }

            total += fact_n;
            n /= 10;
        }

        if (total == temp_n) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
