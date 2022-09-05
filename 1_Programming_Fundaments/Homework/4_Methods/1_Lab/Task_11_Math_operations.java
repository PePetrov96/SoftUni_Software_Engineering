import java.util.Scanner;

public class Task_11_Math_operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();
        int b = Integer.parseInt(scan.nextLine());

        switch (command) {
            case "+":
                add(a,b);
                break;
            case "-":
                subtract(a,b);
                break;
            case "*":
                multiply(a,b);
                break;
            case "/":
                divide(a,b);
                break;
        }

    }
    private static void add(int a, int b) {
        System.out.println(a + b);
    }
    private static void subtract(int a, int b) {
        System.out.println(a - b);
    }
    private static void multiply(int a, int b) {
        System.out.println(a * b);
    }
    private static void divide(int a, int b) {
        System.out.println(a / b);
    }
}