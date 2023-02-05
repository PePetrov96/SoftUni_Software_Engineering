import java.util.Scanner;

public class Task_4_Print_and_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStart = Integer.parseInt(sc.nextLine());
        int numEnd = Integer.parseInt(sc.nextLine());
        int sum = 0;

        for (int i = numStart; i <= numEnd; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println("\nSum: " + sum);
    }
}
