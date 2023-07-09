import java.util.*;

public class Task_2_Chainalysis {
    private static Map<String, List<String>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of transactions
        scanner.nextLine(); // Consume the remaining newline

        fillTheGraph(scanner, n);

        // Print the result
        System.out.println(findConnectedComponents());
    }

    private static void fillTheGraph(Scanner scanner, int n) {
        graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] transaction = scanner.nextLine().split("\\s");
            String from = transaction[0];
            String to = transaction[1];

            // Add entries for from and to addresses if not already present
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            // Add edges between from and to addresses
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }

    private static int findConnectedComponents() {
        // Perform BFS to find connected components
        int count = 0;
        Set<String> visited = new HashSet<>();

        for (String address : graph.keySet()) {
            if (!visited.contains(address)) {
                bfs(graph, address, visited);
                count++;
            }
        }
        return count;
    }

    private static void bfs(Map<String, List<String>> graph, String start, Set<String> visited) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String address = queue.poll();

            for (String neighbor : graph.getOrDefault(address, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}