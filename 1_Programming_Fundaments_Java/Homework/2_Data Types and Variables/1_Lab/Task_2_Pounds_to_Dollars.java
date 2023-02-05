import java.util.Scanner;

public class Task_2_Pounds_to_Dollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double gbp = Double.parseDouble(scan.nextLine());
        double usd = gbp * 1.36;
        System.out.printf("%.3f", usd);
    }
}