import java.util.*;

public class Task_2_Longest_Path {
    static Node[] nodes;
    static int[] longestDistances;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();

            nodes[source].edges.add(new Edge(source, destination, weight));
        }

        int sourceNode = scanner.nextInt();
        int destinationNode = scanner.nextInt();

        longestDistances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(longestDistances, Integer.MIN_VALUE);

        longestDistances[sourceNode] = 0;

        Stack<Node> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                topologicalSort(nodes[i], visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (longestDistances[node.name] != Integer.MIN_VALUE) {
                for (Edge edge : node.edges) {
                    if (longestDistances[edge.destination] < longestDistances[node.name] + edge.weight) {
                        longestDistances[edge.destination] = longestDistances[node.name] + edge.weight;
                    }
                }
            }
        }

        if (longestDistances[destinationNode] == Integer.MIN_VALUE) {
            System.out.println("No path from source to destination.");
        } else {
            System.out.println(longestDistances[destinationNode]);
        }
    }

    public static void topologicalSort(Node node, boolean[] visited, Stack<Node> stack) {
        visited[node.name] = true;
        for (Edge edge : node.edges) {
            if (!visited[edge.destination]) {
                topologicalSort(nodes[edge.destination], visited, stack);
            }
        }
        stack.push(node);
    }

    static class Node {
        int name;
        List<Edge> edges = new ArrayList<>();

        public Node(int name) {
            this.name = name;
        }
    }

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
}
