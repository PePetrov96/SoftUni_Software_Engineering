import java.util.*;

public class Task_6_Big_Trip {
    static int[] distances;
    static int[] prev;
    static ArrayList<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // number of nodes
        int m = scanner.nextInt();  // number of edges

        distances = new int[n + 1];
        prev = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(src, dest, weight));
        }

        int start = scanner.nextInt(); // start node
        int end = scanner.nextInt(); // end node

        if (bellmanFord(n, start, end)) {
            System.out.println("Undefined");
        } else {
            System.out.println(distances[end]);
            printPath(end);
        }
    }

    public static boolean bellmanFord(int n, int start, int end) {
        Arrays.fill(distances, Integer.MIN_VALUE);
        distances[start] = 0;
        for (int i = 1; i <= n; i++) {
            for (Edge edge : edges) {
                if (distances[edge.src] != Integer.MIN_VALUE && distances[edge.src] + edge.weight > distances[edge.dest]) {
                    distances[edge.dest] = distances[edge.src] + edge.weight;
                    prev[edge.dest] = edge.src;
                }
            }
        }

        // Checking for negative cycle
        for (Edge edge : edges) {
            if (distances[edge.src] != Integer.MIN_VALUE && distances[edge.src] + edge.weight > distances[edge.dest]) {
                return true;
            }
        }
        return false;
    }

    public static void printPath(int node) {
        if (node == 0) {
            return;
        }
        printPath(prev[node]);
        System.out.print(node + " ");
    }

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
}
