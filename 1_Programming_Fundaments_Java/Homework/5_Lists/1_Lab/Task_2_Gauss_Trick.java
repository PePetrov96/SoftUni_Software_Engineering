import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_2_Gauss_Trick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int middle = numbers.size() / 2;
        for (int i = 0; i < middle; i++) {
            numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
            numbers.remove(numbers.get(numbers.size() - 1));
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}