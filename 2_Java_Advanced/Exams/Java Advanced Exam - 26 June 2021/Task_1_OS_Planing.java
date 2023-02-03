import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Task_1_OS_Planing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> tasks = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> threads = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(reader.readLine());

        while (true) {
            int task = tasks.peekLast();
            int thread = threads.peekFirst();

            if (task == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", threads.peekFirst(), tasks.peekLast());
                break;
            }

            if (thread >= task) {
                tasks.removeLast();
            }

            threads.remove();
        }

        System.out.println(Arrays.toString(threads.toArray()).replaceAll("[\\[\\],]",""));
    }
}