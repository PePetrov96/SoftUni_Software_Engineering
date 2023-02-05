import java.util.Scanner;

public class Task_2_From_Left_to_the_Right {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            double num1 = Double.parseDouble(scan.next());
            double num2 = Double.parseDouble(scan.next());

            int sum = 0;
            if (num1 > num2) {
                double numFirst = Math.abs(num1);
                while (numFirst > 0) {
                    sum += (numFirst % 10);
                    numFirst /= 10;
                }
            } else {
                double numSecond = Math.abs(num2);
                while (numSecond > 0) {
                    sum += (numSecond % 10);
                    numSecond /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}