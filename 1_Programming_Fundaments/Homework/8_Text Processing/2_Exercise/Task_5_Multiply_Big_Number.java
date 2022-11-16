import java.util.Scanner;

public class Task_5_Multiply_Big_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNum = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int multiplier = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        if (multiplier == 0 || bigNum.isEmpty()) {
            System.out.println(0);
            return;
        }

        int remainder = 0;

        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int number = Integer.parseInt(String.valueOf(bigNum.charAt(i)));

            int currentRes = number * multiplier + remainder;

            if (number * multiplier + remainder < 10) {
                result.append(currentRes);
                remainder = 0;
            } else {
                result.append(currentRes % 10);
                currentRes /= 10;
                remainder = currentRes;
            }

        }
        if (remainder != 0) {
            result.append(remainder);
        }
        System.out.println(result.reverse());
    }
}