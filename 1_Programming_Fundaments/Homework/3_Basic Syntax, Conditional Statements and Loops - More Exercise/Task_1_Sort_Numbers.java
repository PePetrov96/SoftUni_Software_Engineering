import java.util.Scanner;

public class Task_1_Sort_Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        int firstNumber = 0;
        int secondNumber = 0;
        int thirdNumber = 0;
        int two = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= 3; i++) {
            num = Integer.parseInt(scan.nextLine());
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            if (i == 1) {
                firstNumber = num;
            } else if (i == 2) {
                secondNumber = num;
            } else {
                thirdNumber = num;
            }
        }
        if (firstNumber != max && firstNumber != min || firstNumber == secondNumber) {
            two = firstNumber;
        } else if (secondNumber != max && secondNumber != min || secondNumber == thirdNumber) {
            two = secondNumber;
        } else if (thirdNumber != max && thirdNumber != min || firstNumber == thirdNumber) {
            two = thirdNumber;
        }
        System.out.println(max);
        System.out.println(two);
        System.out.println(min);
    }
}