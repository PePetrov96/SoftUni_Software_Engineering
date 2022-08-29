import java.util.Scanner;

public class Task_6_Balanced_Brackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int opening = 0;
        int closing = 0;
        boolean isBalanced = true;

        for (int i = 1; i <= n; i++) {
            String input = scan.nextLine();
            if (input.equals("(")) {
                opening++;
            } else if (input.equals(")")) {
                closing++;
                if (opening - closing != 0) {
                    isBalanced = false;
                }
            }
        }
        if (opening == closing && isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}