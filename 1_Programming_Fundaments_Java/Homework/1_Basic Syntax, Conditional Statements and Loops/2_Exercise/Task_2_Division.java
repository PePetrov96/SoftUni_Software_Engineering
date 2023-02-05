import java.util.Scanner;

public class Task_2_Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int[] divider = {2, 3, 6, 7, 10};
        int max = 0;
        boolean isDivisible = false;
        for (int i = 0; i < divider.length; i++) {
            if (num % divider[i] == 0) {
                max = divider[i];
                isDivisible = true;
            }
        }
        if (isDivisible) {
            System.out.printf("The number is divisible by %d", max);
        } else {
            System.out.println("Not divisible");
        }
    }
}
