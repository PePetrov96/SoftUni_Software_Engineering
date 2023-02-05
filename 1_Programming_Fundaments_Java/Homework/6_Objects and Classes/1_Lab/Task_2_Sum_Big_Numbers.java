import java.math.BigInteger;
import java.util.Scanner;

public class Task_2_Sum_Big_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger num1 = new BigInteger(String.valueOf(scan.nextLine()));
        BigInteger num2 = new BigInteger(String.valueOf(scan.nextLine()));
        BigInteger result = num1.add(num2);
        System.out.println(result);
    }
}