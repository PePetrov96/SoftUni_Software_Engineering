import java.util.Scanner;

public class Task_4_Tribonacci_Sequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(output(n));
    }
    private static String output (int n) {
        String output = "";
        int num1 = 0;
        int num2 = 0;
        int num3 = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                output = 1 + " ";
            } else {
                int sum;
                sum = num1 + num2 + num3;
                num1 = num2;
                num2 = num3;
                num3 = sum;
                output += sum + " ";
            }
        }
        return output;
    }
}