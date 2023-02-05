import java.util.Scanner;

public class Task_9_Greater_of_Two_Values {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String method = sc.nextLine();

        switch (method) {
            case "int":
                System.out.println(getMax(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
                break;
            case "char":
                System.out.println(getMax(sc.nextLine().charAt(0), sc.nextLine().charAt(0)));
                break;
            case "string":
                System.out.println(getMax(sc.nextLine(), sc.nextLine()));
                break;
        }
    }
    static int getMax (int firstNum, int secondNum) {
        return Math.max(firstNum, secondNum);
    }

    static char getMax (char first, char second) {
        if (first >= second) {
            return first;
        }
        return second;
    }
    static String getMax (String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }
}