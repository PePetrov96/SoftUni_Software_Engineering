import java.util.*;

public class Task_3_Guards {
    private static List<Integer> unreachableOutposts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // number of nodes
        int M = scanner.nextInt(); // number of edges

        // Create an adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // Read the edge connections
        for (int i = 0; i < M; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.get(from - 1).add(to - 1);
        }

        int startNode = scanner.nextInt(); // start node
        unreachableOutposts = new ArrayList<>();

        // Perform depth-first search (DFS) from the start node
        boolean[] visited = new boolean[N];
        dfs(graph, startNode - 1, visited);

        // Find the unreachable outposts
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                unreachableOutposts.add(i + 1);
            }
        }

        // Print the unreachable outposts
        System.out.println(unreachableOutposts.toString().replaceAll("[\\[\\],]", ""));

        scanner.close();
    }

    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;

        // Explore the neighbors of the current node
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}
