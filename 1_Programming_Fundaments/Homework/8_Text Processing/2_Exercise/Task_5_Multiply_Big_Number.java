import java.math.BigDecimal;
import java.util.Scanner;

public class Task_5_Multiply_Big_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigDecimal number = new BigDecimal(scan.nextLine());
        number = number.multiply(BigDecimal.valueOf(Integer.parseInt(scan.nextLine())));
        System.out.println(number);
    }
}