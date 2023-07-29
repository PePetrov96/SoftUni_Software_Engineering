import java.util.*;

public class Task_2_Modified_Kruskal_Algorithm {
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

    static class Node {
        int parent;
        int rank;

        public Node(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    static Node[] makeSet(int size) {
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i, 0);
        }
        return nodes;
    }

    static int find(Node[] nodes, int i) {
        if (nodes[i].parent != i) {
            nodes[i].parent = find(nodes, nodes[i].parent);
        }
        return nodes[i].parent;
    }

    static void union(Node[] nodes, int i, int j) {
        int iId = find(nodes, i);
        int jId = find(nodes, j);

        if (iId == jId) {
            return;
        }

        if (nodes[iId].rank < nodes[jId].rank) {
            nodes[iId].parent = jId;
        } else {
            nodes[jId].parent = iId;
            if (nodes[iId].rank == nodes[jId].rank) {
                nodes[iId].rank++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodesCount = Integer.parseInt(scanner.nextLine().split(": ")[1]);
        int edgesCount = Integer.parseInt(scanner.nextLine().split(": ")[1]);

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < edgesCount; i++) {
            String[] input = scanner.nextLine().split(" ");
            int source = Integer.parseInt(input[0]);
            int destination = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            edges.add(new Edge(source, destination, weight));
        }

        edges.sort(Comparator.comparingInt(e -> e.weight));
        Node[] nodes = makeSet(nodesCount);

        int totalWeight = 0;

        for (Edge edge : edges) {
            if (find(nodes, edge.source) != find(nodes, edge.destination)) {
                totalWeight += edge.weight;
                union(nodes, edge.source, edge.destination);
            }
        }

        System.out.println("Minimum spanning forest weight: " + totalWeight);
    }
}
