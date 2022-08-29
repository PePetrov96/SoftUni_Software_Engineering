import java.math.BigDecimal;
import java.util.Scanner;

public class Task_3_Exact_Sum_of_Real_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < n; i++) {
            BigDecimal number = new BigDecimal(scan.nextLine());
            sum = sum.add(number);
        }
        System.out.println(sum);
    }
}