import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_3_Merging_Lists {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        List<Integer> firstNumbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer :: parseInt).collect(Collectors.toList());
        List<Integer> secondNumbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer :: parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        int length = Math.min(firstNumbers.size(), secondNumbers.size());

        for (int i = 0; i < length * 2; i++) {
            if (i % 2 == 0) {
                result.add(firstNumbers.get(0));
                firstNumbers.remove(0);
            } else {
                result.add(secondNumbers.get(0));
                secondNumbers.remove(0);
            }
        }
        printList(firstNumbers, secondNumbers, result);
    }
    private static void printList (List<Integer> num1, List<Integer> num2, List<Integer> result) {
        if (num1.size() > num2.size()) {
            result.addAll(num1);
        } else if (num2.size() > num1.size()) {
            result.addAll(num2);
        }
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}