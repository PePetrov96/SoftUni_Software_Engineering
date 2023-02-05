import java.util.Arrays;
import java.util.Scanner;

public class Task_9_Array_Modifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numberArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer :: parseInt).toArray();

        while (true) {
            String input = scan.next();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("decrease")) {
                for (int i = 0; i < numberArr.length; i++) {
                    numberArr[i] = numberArr[i] - 1;
                }
            } else {
                int num1 = Integer.parseInt(scan.next());
                int num2 = Integer.parseInt(scan.next());
                if (input.equals("swap")) {
                    int temporary = 0;
                    temporary = numberArr[num1];
                    numberArr[num1] = numberArr[num2];
                    numberArr[num2] = temporary;
                } else if (input.equals("multiply")) {
                    numberArr[num1] = numberArr[num1] * numberArr [num2];
                }
            }
        }
        System.out.println(Arrays.toString(numberArr).replaceAll("[\\[\\]]", ""));
    }
}