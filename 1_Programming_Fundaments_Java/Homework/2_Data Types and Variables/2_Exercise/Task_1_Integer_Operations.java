import java.math.BigDecimal;
import java.util.Scanner;

public class Task_1_Integer_Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigDecimal result = new BigDecimal(scan.nextInt());
        result = result.add(BigDecimal.valueOf(scan.nextInt()));
        result = result.divide(BigDecimal.valueOf(scan.nextInt()));
        result = result.multiply(BigDecimal.valueOf(scan.nextInt()));
        System.out.println(result);
    }
}