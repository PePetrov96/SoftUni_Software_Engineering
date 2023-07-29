import java.util.*;

public class Task_1_Bellman_Ford {
    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNodes = scanner.nextInt();
        int numberOfEdges = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < numberOfEdges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(from, to, weight));
        }

        int sourceNode = scanner.nextInt();
        int destinationNode = scanner.nextInt();

        int[] distances = new int[numberOfNodes + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[sourceNode] = 0;

        int[] prev = new int[numberOfNodes + 1];
        Arrays.fill(prev, -1);

        for (int i = 0; i < numberOfNodes; i++) {
            for (Edge edge : edges) {
                if (distances[edge.from] != Integer.MAX_VALUE && distances[edge.from] + edge.weight < distances[edge.to]) {
                    distances[edge.to] = distances[edge.from] + edge.weight;
                    prev[edge.to] = edge.from;
                }
            }
        }

        for (Edge edge : edges) {
            if (distances[edge.from] != Integer.MAX_VALUE && distances[edge.from] + edge.weight < distances[edge.to]) {
                System.out.println("Negative Cycle Detected");
                return;
            }
        }

        List<Integer> path = new ArrayList<>();
        for(int i = destinationNode; i != -1; i = prev[i]) {
            path.add(i);
        }

        Collections.reverse(path);
        System.out.println(String.join(" ", path.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println(distances[destinationNode]);
    }
}
