import java.util.Scanner;

public class Task_2_Nested_Loops {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int limit = Integer.parseInt(scan.nextLine());

        simulateNestedLoops(limit);
    }
    public static void simulateNestedLoops(int limit) {
        simulateNestedLoopsRecursive(new StringBuilder(), 1, limit);
    }

    private static void simulateNestedLoopsRecursive(StringBuilder iterationVariables, int level, int limit) {
        if (level > limit) {
            System.out.println(iterationVariables.toString());
            return;
        }

        for (int i = 1; i <= limit; i++) {
            if (iterationVariables.length() > 0) {
                iterationVariables.append(" ");
            }
            iterationVariables.append(i).append(" ");
            simulateNestedLoopsRecursive(iterationVariables, level + 1, limit);
            iterationVariables.setLength(iterationVariables.length() - String.valueOf(i).length());
            if (iterationVariables.length() > 0) {
                iterationVariables.setLength(iterationVariables.length() - 1);
            }
        }
    }
}