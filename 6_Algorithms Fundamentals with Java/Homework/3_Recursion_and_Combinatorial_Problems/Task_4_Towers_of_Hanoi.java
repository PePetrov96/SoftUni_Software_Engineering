import java.util.*;

public class Task_4_Towers_of_Hanoi {
    private static final Deque<Integer> source = new LinkedList<>();
    private static final Deque<Integer> destination = new LinkedList<>();
    private static final Deque<Integer> spare = new LinkedList<>();
    private static byte steps = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = n; i > 0; i--) {
            source.push(i);
        }

        printStatus();
        solve(n, source, destination, spare);

        scanner.close();
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            steps++;
            printStatus();
        } else {
            solve(disk - 1, source, spare, destination);
            destination.push(source.pop());
            steps++;
            printStatus();
            solve(disk - 1, spare, destination, source);
        }
    }

    private static void printStatus() {
        if (steps != 0) {
            System.out.println("Step #" + steps + ": Moved disk");
        }

        StringJoiner joiner1 = new StringJoiner(", ");
        source.descendingIterator().forEachRemaining(element -> joiner1.add(element.toString()));
        System.out.println(("Source: " + joiner1).trim());

        StringJoiner joiner2 = new StringJoiner(", ");
        destination.descendingIterator().forEachRemaining(element -> joiner2.add(element.toString()));
        System.out.println(("Destination: " + joiner2).trim());

        StringJoiner joiner3 = new StringJoiner(", ");
        spare.descendingIterator().forEachRemaining(element -> joiner3.add(element.toString()));
        System.out.println(("Spare: " + joiner3).trim());

        System.out.println();
    }
}