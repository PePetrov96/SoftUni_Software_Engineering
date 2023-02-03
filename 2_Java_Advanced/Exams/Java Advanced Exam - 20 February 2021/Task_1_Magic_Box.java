import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task_1_Magic_Box {
    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayDeque<Integer> firstBox;
    static Stack<Integer> secondBox;
    static int claimedItems;
    public static void main(String[] args) throws IOException {
        initialize();

        mix();

        printResult();
    }
    private static void printResult(){
        System.out.println(firstBox.isEmpty() ?
                "First magic box is empty." :
                "Second magic box is empty.");

        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }
    }
    private static void mix(){
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.pop();
            int second = secondBox.pop();

            int sum = first + second;

            if (sum % 2 == 0) {
                claimedItems += sum;
            } else {
                firstBox.push(first);
                firstBox.add(second);
            }
        }
    }
    private static void initialize() throws IOException {
        firstBox = Arrays.stream(reader.readLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        secondBox = Arrays.stream(reader.readLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack::new));
    }
}