import java.util.*;

public class Task_5_Undefined {
    static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();

        List<Edge> edgeList = new ArrayList<Edge>();
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            edgeList.add(new Edge(source, destination, weight));
        }

        int source = scanner.nextInt();
        int destination = scanner.nextInt();

        int[] dist = new int[nodes + 1];
        int[] prev = new int[nodes + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i <= nodes - 1; i++) {
            for (Edge edge : edgeList) {
                if (dist[edge.source] != Integer.MAX_VALUE && dist[edge.source] + edge.weight < dist[edge.destination]) {
                    dist[edge.destination] = dist[edge.source] + edge.weight;
                    prev[edge.destination] = edge.source;
                }
            }
        }

        for (Edge edge : edgeList) {
            if (dist[edge.source] != Integer.MAX_VALUE && dist[edge.source] + edge.weight < dist[edge.destination]) {
                System.out.println("Undefined");
                return;
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int v = destination; v != source; v = prev[v])
            path.add(v);
        path.add(source);

        Collections.reverse(path);
        for (int v : path)
            System.out.print(v + " ");
        System.out.println();
        System.out.println(dist[destination]);
    }
}
