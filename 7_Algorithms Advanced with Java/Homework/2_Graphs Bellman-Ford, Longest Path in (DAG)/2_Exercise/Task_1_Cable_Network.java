import java.util.*;

public class Task_1_Cable_Network {
    static class Node {
        int name;
        boolean connected;
        List<Edge> edges = new ArrayList<>();

        public Node(int name) {
            this.name = name;
        }
    }

    static class Edge {
        int weight;
        Node node;

        public Edge(int weight, Node node) {
            this.weight = weight;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine().split(": ")[1]);
        int nodesCount = Integer.parseInt(scanner.nextLine().split(": ")[1]);
        int edgesCount = Integer.parseInt(scanner.nextLine().split(": ")[1]);

        Node[] nodes = new Node[nodesCount];
        for (int i = 0; i < nodesCount; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < edgesCount; i++) {
            String[] input = scanner.nextLine().split(" ");
            int source = Integer.parseInt(input[0]);
            int destination = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            boolean connected = input.length == 4 && input[3].equals("connected");
            nodes[source].edges.add(new Edge(weight, nodes[destination]));
            nodes[destination].edges.add(new Edge(weight, nodes[source]));
            if (connected) {
                nodes[source].connected = true;
                nodes[destination].connected = true;
            }
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        for (Node node : nodes) {
            if (node.connected) {
                queue.addAll(node.edges);
            }
        }

        int usedBudget = 0;
        while (!queue.isEmpty() && budget >= queue.peek().weight) {
            Edge edge = queue.poll();
            if (!edge.node.connected) {
                usedBudget += edge.weight;
                budget -= edge.weight;
                edge.node.connected = true;
                queue.addAll(edge.node.edges);
            }
        }

        System.out.println("Budget used: " + usedBudget);
    }
}
